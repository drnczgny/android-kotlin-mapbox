package com.adrian.project.ui.mappage.recyclerview

import android.databinding.BindingAdapter
import android.util.Log
import com.mapbox.mapboxsdk.maps.MapView

/**
 * Created by cadri on 2017. 10. 22..
 */


@BindingAdapter(value = *arrayOf("onStart"))
fun  setMapOnStart(mapView: MapView, value: Int) {
    Log.e("MapBoxBindingAdapter", "onStart.....")
    mapView.onStart()
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
