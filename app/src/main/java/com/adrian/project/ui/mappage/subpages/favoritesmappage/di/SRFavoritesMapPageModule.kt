package com.adrian.project.ui.mappage.subpages.favoritesmappage.di

import com.adrian.project.scope.FragmentScope
import com.adrian.project.ui.mappage.subpages.favoritesmappage.model.SRFavoritesMapPageModel
import com.adrian.project.ui.mappage.subpages.favoritesmappage.service.FavoritesMapService
import com.adrian.project.ui.mappage.subpages.favoritesmappage.view.SRFavoritesMapPageFragment
import com.adrian.project.ui.mappage.subpages.favoritesmappage.view.SRFavoritesMapPageRouter
import com.adrian.project.ui.mappage.subpages.favoritesmappage.viewmodel.SRFavoritesMapViewModel
import com.adrian.project.ui.mappage.subpages.map.MapBoxMap
import com.adrian.project.ui.mappage.subpages.map.MapController
import dagger.Module
import dagger.Provides
import im.delight.android.location.SimpleLocation
import retrofit2.Retrofit
import javax.inject.Named

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
class SRFavoritesMapPageModule {

    @FragmentScope
    @Provides
    fun providesSRFavoritesMapPageRouter(sRFavoritesMapPageFragment: SRFavoritesMapPageFragment): SRFavoritesMapPageRouter
            = sRFavoritesMapPageFragment

    @FragmentScope
    @Provides
    fun providesSRFavoritesMapService(@Named("jsonplaceholderapi") retrofit: Retrofit): FavoritesMapService
            = retrofit.create(FavoritesMapService::class.java)

    @FragmentScope
    @Provides
    fun providesSRFavoritesMapPageModel(favoritesMapService: FavoritesMapService)
            = SRFavoritesMapPageModel(favoritesMapService)

    @FragmentScope
    @Provides
    fun providesMapBoxMap(fragment: SRFavoritesMapPageFragment, simpleLocation: SimpleLocation): MapController
            = MapBoxMap(fragment, simpleLocation)


    @FragmentScope
    @Provides
    fun providesSRFavoritesMapPageViewModel(router: SRFavoritesMapPageRouter, model: SRFavoritesMapPageModel, mapController: MapController)
            = SRFavoritesMapViewModel(router, model, mapController)
}