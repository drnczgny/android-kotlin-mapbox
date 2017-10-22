package com.adrian.project.ui.mappage.recyclerview

import android.databinding.BindingAdapter
import android.util.Log
import com.adrian.project.R
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback

/**
 * Created by cadri on 2017. 10. 22..
 */



@BindingAdapter(value = *arrayOf("onStart"))
fun  setAddMarker(mapView: MapView, value: Int) {
    mapView.getMapAsync(OnMapReadyCallback { mapboxMap ->
        mapboxMap.addMarker(MarkerOptions()
                .position(LatLng(48.13863, 11.57603))
                .title(mapView.context.getString(R.string.draw_marker_options_title))
                .snippet(mapView.context.getString(R.string.draw_marker_options_snippet)))
    })
}

@BindingAdapter(value = *arrayOf("onResume"))
fun  setMapOnResume(mapView: MapView, value: Int) {
    Log.e("MapBoxBindingAdapter", "onResume.....")
    mapView.onResume()
}

@BindingAdapter(value = *arrayOf("onPause"))
fun  setMapOnPause(mapView: MapView, value: Int) {
    Log.e("MapBoxBindingAdapter", "onPause.....")
    mapView.onPause()
}

@BindingAdapter(value = *arrayOf("onStop"))
fun  setMapOnStop(mapView: MapView, value: Int) {
    Log.e("MapBoxBindingAdapter", "onStop.....")
    mapView.onStop()
}

@BindingAdapter(value = *arrayOf("onDestroy"))
fun  setMapOnDestroy(mapView: MapView, value: Int) {
    Log.e("MapBoxBindingAdapter", "onDestroy.....")
    mapView.onDestroy()
}

@BindingAdapter(value = *arrayOf("onLowMemory"))
fun  setMapOnLowMemory(mapView: MapView, value: Int) {
    Log.e("MapBoxBindingAdapter", "onLowMemory.....")
    mapView.onLowMemory()
}
