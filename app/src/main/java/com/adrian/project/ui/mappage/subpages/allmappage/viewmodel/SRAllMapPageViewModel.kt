package com.adrian.project.ui.mappage.subpages.allmappage.viewmodel

import android.databinding.Bindable
import com.adrian.project.BR
import com.adrian.project.R
import com.adrian.project.base.BaseViewModel
import com.adrian.project.base.ListItemViewModel
import com.adrian.project.ui.mappage.subpages.allmappage.model.SRAllMapPageModel
import com.adrian.project.ui.mappage.subpages.allmappage.view.SRAllMapPageRouter

/**
 * Created by cadri on 2017. 08. 06..
 */

class SRAllMapPageViewModel
constructor(val model: SRAllMapPageModel, val router: SRAllMapPageRouter) : BaseViewModel(), SRAllMapPageModel.Callback {

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