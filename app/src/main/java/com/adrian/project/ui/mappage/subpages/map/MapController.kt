package com.adrian.project.ui.mappage.subpages.map

import com.mapbox.mapboxsdk.maps.MapView

/**
 * Created by cadri on 2017. 10. 22..
 */

interface MapController {

    /***
     * Set/init map from fragment
     */
    fun setMap(mapView: MapView)

    fun addMarker(lat: Double, lon: Double)

    fun clearMap()

}