package com.adrian.project.ui.mappage.subpages.map

import android.os.Bundle
import com.mapbox.mapboxsdk.maps.MapView
import im.delight.android.location.SimpleLocation

/**
 * Created by cadri on 2017. 10. 22..
 */

interface MapController {

    /***
     * Set/init map from fragment
     */
    fun setMap(mapView: MapView)

    fun getCurrentLocation()

    fun showCurrentLocation()

    fun addMarker(lat: Double, lon: Double)

    fun addMarker(location: SimpleLocation.Point)

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