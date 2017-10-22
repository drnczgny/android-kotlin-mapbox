package com.adrian.project.ui.mappage.subpages.map

import android.os.Bundle
import android.util.Log
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback

/**
 * Created by cadri on 2017. 10. 22..
 */

class MapBoxMap: MapController {


    lateinit var mapView: MapView

    object logging {
        val TAG = MapBoxMap::class.java.simpleName
    }

    override fun setMap(mapView: MapView) {
        this.mapView = mapView
    }

    override fun onCreate(outState: Bundle?) {
        Log.e(logging.TAG, "onStart ...");
        mapView.onCreate(outState);
    }

    override fun onStart() {
        Log.e(logging.TAG, "onStart ...");
        mapView.onStart();
    }

    override fun onResume() {
        Log.e(logging.TAG, "onResume ...");
        mapView.onResume();
    }

    override fun onPause() {
        Log.e(logging.TAG, "onPause ...");
        mapView.onPause();
    }

    override fun onStop() {
        Log.e(logging.TAG, "onStop ...");
        mapView.onStop();
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.e(logging.TAG, "onSaveInstanceState ...");
        mapView.onSaveInstanceState(outState);
    }

    override fun onLowMemory() {
        Log.e(logging.TAG, "onLowMemory ...");
        mapView.onLowMemory();
    }

    override fun onDestroy() {
        Log.e(logging.TAG, "onDestroy ...");
        mapView.onDestroy();
    }

    override fun addMarker(lat: Double, lon: Double) {
        mapView.getMapAsync(OnMapReadyCallback { mapboxMap ->
            mapboxMap.addMarker(MarkerOptions()
                    .position(LatLng(lat, lon))
                    .title("asdasdasd")
                    .snippet("asdasd"))
        })
    }

    override fun clearMap() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}