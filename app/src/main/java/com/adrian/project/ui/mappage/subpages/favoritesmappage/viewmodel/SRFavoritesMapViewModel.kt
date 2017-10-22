package com.adrian.project.ui.mappage.subpages.favoritesmappage.viewmodel

import android.databinding.Bindable
import com.adrian.project.BR
import com.adrian.project.R
import com.adrian.project.base.BaseViewModel
import com.adrian.project.base.ListItemViewModel
import com.adrian.project.ui.mappage.subpages.favoritesmappage.model.SRFavoritesMapPageModel
import com.adrian.project.ui.mappage.subpages.favoritesmappage.view.SRFavoritesMapPageRouter

/**
 * Created by cadri on 2017. 08. 16..
 */

class SRFavoritesMapViewModel constructor(val router: SRFavoritesMapPageRouter, val model: SRFavoritesMapPageModel) : BaseViewModel(), SRFavoritesMapPageModel.Callback {

    @Bindable
    var comments: List<ListItemViewModel> = ArrayList<ListItemViewModel>()
        set(value) {
            if (comments != value && !comments.equals(value)) {
                field = value
                notifyPropertyChanged(BR.comments)
            }
        }

    init {
        model.registerCallback(this)
        model.findAllComment()
    }

    fun onDestroy() {
        model.unRegisterCallback()
    }

    @Bindable
    fun getItemLayoutId() = R.layout.list_item_comment

    @Bindable
    fun getVariableId(): Int {
        return BR.viewModel
    }
}