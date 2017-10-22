package com.adrian.project.ui.mappage.subpages.map

import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback

/**
 * Created by cadri on 2017. 10. 22..
 */

class MapBoxMap: MapController {

    lateinit var mapView: MapView

    override fun setMap(mapView: MapView) {
     this.mapView = mapView
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