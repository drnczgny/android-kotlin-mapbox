package com.adrian.project.ui.mappage.subpages.favoritesmappage.model

import com.adrian.project.ui.mappage.subpages.favoritesmappage.service.FavoritesMapService
import com.adrian.project.ui.mappage.subpages.favoritesmappage.viewmodel.Comment
import com.adrian.project.ui.mappage.subpages.favoritesmappage.viewmodel.CommentItemViewModel
import com.annimon.stream.Collectors
import com.annimon.stream.Stream

/**
 * Created by cadri on 2017. 08. 16..
 */

class SRFavoritesMapPageModel constructor(val service: FavoritesMapService) {

    object name {
        @JvmStatic
        val TAG = SRFavoritesMapPageModel::class.java.simpleName
    }

    var callback: SRFavoritesMapPageModel.Callback? = null

    init {
    }

    fun findAllComment() {
    }

    fun registerCallback(callback: SRFavoritesMapPageModel.Callback) {
        this.callback = callback
    }

    fun unRegisterCallback() {
        this.callback = null
    }

    private fun convertToViewModel(comment: Comment) = CommentItemViewModel(comment)

    private fun convertToViewModels(comments: List<Comment>): List<CommentItemViewModel>
            = Stream.of(comments).map { comment -> convertToViewModel(comment) }.collect(Collectors.toList())

    interface Callback {

    }
}