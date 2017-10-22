package com.adrian.project.ui.mappage.subpages.map

import android.os.Bundle
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


    // Lifecycle methods

    fun onCreate(outState: Bundle?)

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onSaveInstanceState(outState: Bundle)

    fun onLowMemory()

    fun onDestroy()





}