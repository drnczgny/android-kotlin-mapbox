package com.adrian.project.ui.mappage.subpages.favoritesmappage.di

import android.content.Context
import com.adrian.project.R
import com.adrian.project.scope.FragmentScope
import com.adrian.project.ui.mappage.subpages.favoritesmappage.model.SRFavoritesMapPageModel
import com.adrian.project.ui.mappage.subpages.favoritesmappage.service.FavoritesMapService
import com.adrian.project.ui.mappage.subpages.favoritesmappage.view.SRFavoritesMapPageFragment
import com.adrian.project.ui.mappage.subpages.favoritesmappage.view.SRFavoritesMapPageRouter
import com.adrian.project.ui.mappage.subpages.favoritesmappage.viewmodel.SRFavoritesMapViewModel
import com.mapbox.mapboxsdk.Mapbox
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
class SRFavoritesMapPageModule {

    @FragmentScope
    @Provides
    fun providesSRFavoritesMapPageRouter(sRFavoritesMapPageFragment: SRFavoritesMapPageFragment): SRFavoritesMapPageRouter = sRFavoritesMapPageFragment

    @FragmentScope
    @Provides
    fun providesSRFavoritesMapService(@Named("jsonplaceholderapi") retrofit: Retrofit): FavoritesMapService = retrofit.create(FavoritesMapService::class.java)

    @FragmentScope
    @Provides
    fun providesSRFavoritesMapPageModel(favoritesMapService: FavoritesMapService) = SRFavoritesMapPageModel(favoritesMapService)

    @FragmentScope
    @Provides
    fun providesSRFavoritesMapPageViewModel(router: SRFavoritesMapPageRouter, model: SRFavoritesMapPageModel) = SRFavoritesMapViewModel(router, model)

    @FragmentScope
    @Provides
    fun provideMapBox(@Named("ApplicationContext") context: Context): Mapbox {
        return Mapbox.getInstance(context, context.getString(R.string.map_box_token));
    }
}