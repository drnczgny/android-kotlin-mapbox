package com.adrian.project.ui.mappage.subpages.photospage.di

import com.adrian.project.data.ApiService
import com.adrian.project.scope.FragmentScope
import com.adrian.project.ui.mappage.subpages.photospage.PhotosPageModel
import com.adrian.project.ui.mappage.subpages.photospage.PhotosPageFragment
import com.adrian.project.ui.mappage.subpages.photospage.PhotosPageRouter
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
class PhotosPageModule {

    @FragmentScope
    @Provides
    fun providesPhotosPageRouter(photosPageFragment: PhotosPageFragment): PhotosPageRouter = photosPageFragment

    @FragmentScope
    @Provides
    fun providesPhotosPageModel(apiService: ApiService) = PhotosPageModel(apiService)
}