package com.adrian.project.ui.mappage.subpages.map

import android.Manifest
import android.animation.TypeEvaluator
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.util.Log
import com.adrian.project.R
import com.mapbox.mapboxsdk.annotations.Icon
import com.mapbox.mapboxsdk.annotations.IconFactory
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.annotations.MarkerViewOptions
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import im.delight.android.location.SimpleLocation


/**
 * Mapbox native implementation
 * Created by cadri on 2017. 10. 22..
 */

class MapBoxMap constructor(val fragment: Fragment, val simpleLocation: SimpleLocation) : MapController {

    private object log {
        val TAG = MapBoxMap::class.java.simpleName
    }

    private object static {
        val DEFAULT_ZOOM_LEVEL: Double = 10.0
        val ZOOM_LEVEL_RANGE: Double = 12.0
    }

    lateinit var mapView: MapView

    lateinit var currentLocation: SimpleLocation.Point

    lateinit var markerIcon: Icon

    var currentZoomLevel: Double = static.DEFAULT_ZOOM_LEVEL

    override fun setMap(mapView: MapView) {
        this.mapView = mapView
    }

    override fun onCreate(outState: Bundle?) {
        Log.e(log.TAG, "onStart ...");
        mapView.onCreate(outState);

        markerIcon = IconFactory.getInstance(fragment.activity).fromResource(R.drawable.mapbox_marker_icon_default)
        setupCameraChangeListener()

        getCurrentLocation()
        addCurrentLocationMarker(currentLocation, "Current position", "Budapest")
        showStartingView()

        setupOnMarkerClickListener()
    }

    override fun onStart() {
        Log.e(log.TAG, "onStart ...");
        mapView.onStart();
    }

    override fun onResume() {
        Log.e(log.TAG, "onResume ...");
        mapView.onResume();
    }

    override fun onPause() {
        Log.e(log.TAG, "onPause ...");
        mapView.onPause();
    }

    override fun onStop() {
        Log.e(log.TAG, "onStop ...");
        mapView.onStop();
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.e(log.TAG, "onSaveInstanceState ...");
        mapView.onSaveInstanceState(outState);
    }

    override fun onLowMemory() {
        Log.e(log.TAG, "onLowMemory ...");
        mapView.onLowMemory();
    }

    override fun onDestroy() {
        Log.e(log.TAG, "onDestroy ...");
        mapView.onDestroy();
    }


    override fun showStartingView() {
        val defaultCameraPosition = createNewCameraPosition(currentLocation, static.DEFAULT_ZOOM_LEVEL, 30.0)
        animateCameraToPosition(defaultCameraPosition)
    }

    override fun addMarker(location: SimpleLocation.Point) {
        mapView.getMapAsync(OnMapReadyCallback { mapboxMap ->
            mapboxMap.addMarker(MarkerOptions()
                    .position(LatLng(location.latitude, location.longitude)))
        })
    }

    override fun addMarker(location: SimpleLocation.Point, title: String, snippet: String) {
        mapView.getMapAsync(OnMapReadyCallback { mapboxMap ->
            mapboxMap.addMarker(MarkerOptions()
                    .position(LatLng(location.latitude, location.longitude))
                    .title(title)
                    .snippet(snippet))
        })
    }

    private fun addCurrentLocationMarker(location: SimpleLocation.Point, title: String, snippet: String) {
        val icon = IconFactory.getInstance(fragment.activity).fromResource(R.drawable.mapbox_mylocation_icon_default)

        mapView.getMapAsync(OnMapReadyCallback { mapboxMap ->
            mapboxMap.addMarker(MarkerViewOptions()
                    .position(LatLng(location.latitude, location.longitude))
                    .title(title)
                    .snippet(snippet)
                    .icon(icon))
        })
    }

    override fun addMarkerWithView(location: SimpleLocation.Point) {
//        val icon = IconFactory.getInstance(fragment.activity).fromResource(R.drawable.mapbox_mylocation_icon_bearing)
        val icon = markerIcon

        mapView.getMapAsync(OnMapReadyCallback { mapboxMap ->
            mapboxMap.addMarker(MarkerViewOptions()
                    .position(LatLng(location.latitude, location.longitude))
                    .icon(icon))
        })
    }

    override fun getCurrentLocation() {
        requestForLocationPermission()
        simpleLocation.beginUpdates()
        updateCurrentPosition(simpleLocation.getLatitude(), simpleLocation.getLongitude())
        simpleLocation.endUpdates()
    }

    override fun showCurrentLocation() {
        mapView.getMapAsync { mapboxMap ->
            val position = CameraPosition.Builder()
                    .target(LatLng(currentLocation.latitude, currentLocation.longitude))
                    .zoom(14.0)
                    .tilt(30.0) // Set the camera tilt
                    .build() // Creates a CameraPosition from the builder
            animateCameraToPosition(position)
        }
    }

    override fun animateCameraToPosition(cameraPosition: CameraPosition, duration: Int) {
        mapView.getMapAsync { mapboxMap ->
            mapboxMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition), duration)
        }
    }

    override fun clearMap() {
        mapView.getMapAsync { mapboxMap ->
            mapboxMap.clear()
        }
    }

    private fun zoomLevelRangeChanged(zoomLevel: Double): Boolean {
        var zoomLevelRangeChanged = false
        if (currentZoomLevel < static.ZOOM_LEVEL_RANGE) {
            zoomLevelRangeChanged = zoomLevel >= static.ZOOM_LEVEL_RANGE
        } else {
            zoomLevelRangeChanged = zoomLevel < static.ZOOM_LEVEL_RANGE
        }
        currentZoomLevel = zoomLevel
        return zoomLevelRangeChanged
    }

    private fun setupOnMarkerClickListener() {
        mapView.getMapAsync { mapboxMap ->
            mapboxMap.setOnMarkerClickListener(MapboxMap.OnMarkerClickListener { marker ->
                Log.e(log.TAG, "marker click ...")
                true
            })
        }
    }

    private fun setupCameraChangeListener() {
        mapView.getMapAsync { mapboxMap ->
            mapboxMap.setOnCameraChangeListener(MapboxMap.OnCameraChangeListener { cameraPostion ->
                //                if (cameraPostion.zoom > 16) {
//                    markerIcon = IconFactory.getInstance(fragment.activity).fromResource(R.drawable.mapbox_mylocation_icon_bearing)
//                } else {
//
//                    markerIcon = IconFactory.getInstance(fragment.activity).fromResource(R.drawable.mapbox_mylocation_icon_default)
//                }
                var zoomLevelRangeChanged = zoomLevelRangeChanged(cameraPostion.zoom)
                if (zoomLevelRangeChanged) {
                    if (currentZoomLevel > static.ZOOM_LEVEL_RANGE) {
//                        markerIcon = IconFactory.getInstance(fragment.activity).fromResource(R.drawable.mapbox_mylocation_icon_bearing)
//                        markerIcon = IconFactory.getInstance(fragment.activity).fromResource(R.drawable.mapbox_info_icon_selected)
                        markerIcon = IconFactory.getInstance(fragment.activity).fromResource(R.drawable.icon_custom_location)
                    } else {
//                        markerIcon = IconFactory.getInstance(fragment.activity).fromResource(R.drawable.mapbox_marker_icon_default)
//                        markerIcon = IconFactory.getInstance(fragment.activity).fromResource(R.drawable.mapbox_info_icon_default)
                        markerIcon = IconFactory.getInstance(fragment.activity).fromResource(R.drawable.icon_custom_location)
                    }

                    clearMap()
                    testData()
                }
            })
        }
    }

    private fun requestForLocationPermission() {
        if (Build.VERSION.SDK_INT < 23) {
            if (!simpleLocation.hasLocationEnabled()) {
                SimpleLocation.openSettings(fragment.context);
            }
        } else {
            ActivityCompat.requestPermissions(fragment.activity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        }
    }

    private fun createNewCameraPosition(location: SimpleLocation.Point, zoom: Double = 15.0, tilt: Double = 30.0): CameraPosition {
        val cameraPosition = CameraPosition.Builder()
                .target(LatLng(location.latitude, location.longitude))
                .zoom(zoom)
                .tilt(tilt) // Set the camera tilt
                .build() // Creates a CameraPosition from the builder
        return cameraPosition
    }

    private fun updateCurrentPosition(lat: Double, lon: Double) {
        currentLocation = SimpleLocation.Point(lat, lon)
    }

//    override fun showCurrentLocation() {
//        mapView.getMapAsync { mapboxMap ->
//            //            // Toast instructing user to tap on the map
//////            Toast.makeText(
//////                    this@AnimateMapCameraActivity,
//////                    getString(R.string.tap_on_map_instruction),
//////                    Toast.LENGTH_LONG
//////            ).show()
////
////            // When user clicks the map, animate to new camera location
//            mapboxMap.setOnMapClickListener {
//                val position = CameraPosition.Builder()
//                        .target(LatLng(48.50550, 11.07520)) // Sets the new camera position
//                        .zoom(17.0) // Sets the zoom
//                        .tilt(30.0) // Set the camera tilt
//                        .build() // Creates a CameraPosition from the builder
//
//                mapboxMap.animateCamera(CameraUpdateFactory
//                        .newCameraPosition(position), 2000)
//            }
//        }
//    }

    /**
     * Animate marker from point to point
     */
//    override fun showCurrentLocation() {
//
//        mapView.getMapAsync { mapboxMap ->
//            val marker = mapboxMap.addMarker(MarkerViewOptions()
//                    .position(LatLng(64.900932, -18.167040)))
//
//            mapboxMap.setOnMapClickListener { point ->
//                // When the user clicks on the map, we want to animate the marker to that
//                // location.
//                val markerAnimator = ObjectAnimator.ofObject(marker, "position",
//                        LatLngEvaluator(), marker.position, point)
//                markerAnimator.duration = 2000
//                markerAnimator.start()
//            }
//        }
//    }


    private class LatLngEvaluator : TypeEvaluator<LatLng> {
        // Method is used to interpolate the marker animation.

        private val latLng = LatLng()

        override fun evaluate(fraction: Float, startValue: LatLng, endValue: LatLng): LatLng {
            latLng.latitude = startValue.latitude + (endValue.latitude - startValue.latitude) * fraction
            latLng.longitude = startValue.longitude + (endValue.longitude - startValue.longitude) * fraction
            return latLng
        }
    }

    override fun testData() {
//        val latRange = 0.0055
//        val lonRange = 0.0055
        val latRange = 0.0015
        val lonRange = 0.0015
        var lat = 47.447716
        var lon = 19.019703
        for (i in 1..200) {
            addMarkerWithView(SimpleLocation.Point(lat, lon))
            lat += latRange
            lon += lonRange
        }
    }

//    override fun testData() {
//        var mapPoint1 = MapPoint(47.497716, 19.099703)
//        var mapPoint2 = MapPoint(47.553653, 19.040356)
//        var mapPoint3 = MapPoint(47.486743, 19.094585)
//        var mapPoint4 = MapPoint(47.533242, 19.078488)
//        var mapPoint5 = MapPoint(47.509532, 19.003987)
//        var mapPoint6 = MapPoint(47.524778, 19.046731)
//        var mapPoint7 = MapPoint(47.456169, 19.099652)
//        var list = listOf<MapPoint>(mapPoint1, mapPoint2, mapPoint3, mapPoint4, mapPoint5, mapPoint6, mapPoint7)
//        for (item in list) {
//            addMarkerWithView(SimpleLocation.Point(item.lat, item.lon))
//        }
//    }

    /** Callback that can be implemented in order to listen for events  */
    interface Listener {

        /** Called whenever the device's position changes so that you can call [SimpleLocation.getPosition]  */
        fun onPositionChanged()

    }
}