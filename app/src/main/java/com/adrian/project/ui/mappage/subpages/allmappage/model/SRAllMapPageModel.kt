package com.adrian.project.ui.mappage.subpages.allmappage.model

import com.adrian.project.ui.mappage.subpages.allmappage.service.AllMapService
import com.adrian.project.ui.mappage.subpages.allmappage.viewmodel.Album
import com.adrian.project.ui.mappage.subpages.allmappage.viewmodel.AlbumItemViewModel

/**
 * Created by cadri on 2017. 08. 05..
 */

class SRAllMapPageModel constructor(val allMapService: AllMapService) {

    object name {
        @JvmStatic val TAG = SRAllMapPageModel::class.java.simpleName
    }

    var callback: Callback? = null

    init {
    }

    fun findAll() {

    }

    fun testAlbums(): List<AlbumItemViewModel> {
        return listOf(
                AlbumItemViewModel(Album(1, 1, "title1")),
                AlbumItemViewModel(Album(2, 2, "title2")),
                AlbumItemViewModel(Album(3, 3, "title3")),
                AlbumItemViewModel(Album(4, 4, "title4")))
    }

    fun registerCallback(callback: Callback) {
        this.callback = callback
    }

    fun unRegisterCallback() {
        this.callback = null
    }

    interface Callback {

    }
}