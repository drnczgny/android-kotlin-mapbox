package com.adrian.project.ui.mappage.subpages.allmappage.viewmodel

import android.databinding.Bindable
import android.util.Log
import android.view.View
import com.adrian.project.BR
import com.adrian.project.R
import com.adrian.project.base.BaseViewModel
import com.adrian.project.base.ListItemViewModel
import com.adrian.project.ui.mappage.subpages.allmappage.model.SRAllMapPageModel
import com.adrian.project.ui.mappage.subpages.allmappage.view.SRAllMapPageRouter
import com.adrian.project.ui.mappage.subpages.map.MapController
import im.delight.android.location.SimpleLocation

/**
 * Created by cadri on 2017. 08. 06..
 */

class SRAllMapPageViewModel
constructor(val model: SRAllMapPageModel,
            val router: SRAllMapPageRouter,
            val mapController: MapController) : BaseViewModel(), SRAllMapPageModel.Callback {

    object logging {
        val TAG = SRAllMapPageViewModel::class.java.simpleName
    }

    @Bindable
    var albums: List<ListItemViewModel> = model.testAlbums()
        set(value) {
            if (albums != value && !albums.equals(value)) {
                field = value
                notifyPropertyChanged(BR.albums)
            }
        }

    init {
        model.registerCallback(this)
    }

    fun onClickAddPin(view: View) {
        Log.e(logging.TAG, "onClickAddPin ...");
        var lat: Double = 47.13863
        var lon: Double = 11.57603
        for (i in 1..20) {
            lat = lat + 0.1
            lon = lon + 0.1
            mapController.addMarkerWithView(SimpleLocation.Point(lat, lon))
        }
    }

    fun onClickCurrentLocataion(view: View) {
        Log.e(logging.TAG, "onClickCurrentLocataion ...");
        mapController.showCurrentLocation()
    }

    fun onCreateView() {
    }

    fun onDestroy() {
        model.unRegisterCallback()
    }

    @Bindable
    fun getItemLayoutId() = R.layout.list_item_album

    @Bindable
    fun getVariableId(): Int {
        return BR.viewModel
    }

}