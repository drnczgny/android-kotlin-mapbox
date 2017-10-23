package com.adrian.project.ui.mappage.subpages.allmappage.di

import com.adrian.project.scope.FragmentScope
import com.adrian.project.ui.mappage.subpages.allmappage.model.SRAllMapPageModel
import com.adrian.project.ui.mappage.subpages.allmappage.service.AllMapService
import com.adrian.project.ui.mappage.subpages.allmappage.view.SRAllMapPageFragment
import com.adrian.project.ui.mappage.subpages.allmappage.view.SRAllMapPageRouter
import com.adrian.project.ui.mappage.subpages.allmappage.viewmodel.SRAllMapPageViewModel
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
class SRAllMapPageModule {

    @FragmentScope
    @Provides
    fun providesSRAllMapPageRouter(sRAllMapPageFragment: SRAllMapPageFragment): SRAllMapPageRouter
            = sRAllMapPageFragment

    @FragmentScope
    @Provides
    fun providesSRAllMapService(@Named("jsonplaceholderapi") retrofit: Retrofit): AllMapService
            = retrofit.create(AllMapService::class.java)

    @FragmentScope
    @Provides
    fun providesSRAllMapPageModel(allMapService: AllMapService)
            = SRAllMapPageModel(allMapService)

    @FragmentScope
    @Provides
    fun providesMapBoxMap(fragment: SRAllMapPageFragment, simpleLocation: SimpleLocation): MapController
            = MapBoxMap(fragment, simpleLocation)


    @FragmentScope
    @Provides
    fun providesSRAllMapPageViewModel(model: SRAllMapPageModel, router: SRAllMapPageRouter, mapController: MapController)
            = SRAllMapPageViewModel(model, router, mapController)
}