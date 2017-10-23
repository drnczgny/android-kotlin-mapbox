package com.adrian.project.ui.mappage.di

import android.content.Context
import com.adrian.kotlinrecyclerviewdagger.main.di.ActivityScope
import com.adrian.project.data.ApiService
import com.adrian.project.ui.main.MapPageActivity
import com.adrian.project.ui.mappage.subpages.postspage.MapPageModel
import com.adrian.project.ui.mappage.subpages.postspage.MapPageRouter
import com.adrian.project.ui.mappage.viewmodel.MapPageViewModel
import com.adrian.project.ui.mappage.viewpager.MapViewPagerAdapter
import com.adrian.project.ui.mappage.viewpager.MapViewPagerDataModel
import dagger.Module
import dagger.Provides
import im.delight.android.location.SimpleLocation
import javax.inject.Named

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
class MapPageModule {

    @ActivityScope
    @Provides
    fun providesMapPageRouter(mapPageActivity: MapPageActivity): MapPageRouter
            = mapPageActivity

    @ActivityScope
    @Provides
    fun providesMapPageModel(apiService: ApiService)
            = MapPageModel(apiService)

    @ActivityScope
    @Provides
    fun providesMapPageViewModel(mapPageModel: MapPageModel, mapPageRouter: MapPageRouter)
            = MapPageViewModel(mapPageModel, mapPageRouter)

    @ActivityScope
    @Provides
    fun providesMapPageViewPagerDataModel()
            = MapViewPagerDataModel()

    @ActivityScope
    @Provides
    fun providesMapPageViewPagerAdapter(mapPageActivity: MapPageActivity, datamodel: MapViewPagerDataModel)
            = MapViewPagerAdapter(mapPageActivity.supportFragmentManager, datamodel)

    @ActivityScope
    @Provides
    fun provideSimpleLocation(@Named("ApplicationContext") context: Context): SimpleLocation
            = SimpleLocation(context)

}