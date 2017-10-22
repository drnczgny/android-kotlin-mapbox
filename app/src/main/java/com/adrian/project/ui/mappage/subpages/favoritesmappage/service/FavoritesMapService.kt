package com.adrian.project.ui.mappage.subpages.favoritesmappage.service

import com.adrian.project.ui.mappage.subpages.favoritesmappage.viewmodel.Comment
import retrofit2.http.GET
import rx.Observable

/**
 * Created by cadri on 2017. 08. 16..
 */

interface FavoritesMapService {

    @GET("/comments")
    fun findAllComment(): Observable<List<Comment>>

}