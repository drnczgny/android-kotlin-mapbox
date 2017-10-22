package com.adrian.project.ui.mappage.subpages.allmappage.service

import com.adrian.project.ui.mappage.subpages.allmappage.viewmodel.Album
import retrofit2.http.GET
import rx.Observable

/**
 * Created by cadri on 2017. 08. 06..
 */

interface AllMapService {

    @GET("/albums")
    fun findAllAlbum(): Observable<List<Album>>

}