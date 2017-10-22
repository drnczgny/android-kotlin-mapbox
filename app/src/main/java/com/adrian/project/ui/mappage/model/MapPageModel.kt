package com.adrian.project.ui.mappage.subpages.postspage

import com.adrian.project.data.ApiService

/**
 * Created by cadri on 2017. 08. 05..
 */

class MapPageModel constructor(val apiService: ApiService){

    fun callApiService() = apiService.fakeApiCall()

}