package com.adrian.project.ui.mappage.subpages.map

import android.os.Bundle
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.maps.MapView
import im.delight.android.location.SimpleLocation

/**
 * Created by cadri on 2017. 10. 22..
 */

interface MapController {

    /**
     * Set/init map from fragment
     */
    fun setMap(mapView: MapView)

    /**
     * Get current location
     */
    fun getCurrentLocation()

    /**
     * Show and animate to current location
     */
    fun showCurrentLocation()

    /**
     * Add marker to map
     */
    fun addMarker(location: SimpleLocation.Point, title: String, snippet: String)

    /**
     * Add marker to map
     */
    fun addMarker(location: SimpleLocation.Point)

    /**
     * Animate camera to a position
     */
    fun animateCameraToPosition(cameraPosition: CameraPosition, duration: Int = 2000)

    /**
     * Clear markers from map
     */
    fun clearMap()

    // ---------------------------------------------------------------------------------
    // Lifecycle methods
    // ---------------------------------------------------------------------------------

    fun onCreate(outState: Bundle?)

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onSaveInstanceState(outState: Bundle)

    fun onLowMemory()

    fun onDestroy()
}