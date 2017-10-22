package com.adrian.project.ui.mappage.di

import com.adrian.project.scope.FragmentScope
import com.adrian.project.ui.mappage.subpages.allmappage.di.SRAllMapPageModule
import com.adrian.project.ui.mappage.subpages.allmappage.view.SRAllMapPageFragment
import com.adrian.project.ui.mappage.subpages.favoritesmappage.di.SRFavoritesMapPageModule
import com.adrian.project.ui.mappage.subpages.favoritesmappage.view.SRFavoritesMapPageFragment
import com.adrian.project.ui.mappage.subpages.photospage.PhotosPageFragment
import com.adrian.project.ui.mappage.subpages.photospage.di.PhotosPageModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
abstract class MapPageFragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(SRAllMapPageModule::class))
    abstract fun bindAlbumsPageFragment(): SRAllMapPageFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(SRFavoritesMapPageModule::class))
    abstract fun bindCommentsPageFragment(): SRFavoritesMapPageFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(PhotosPageModule::class))
    abstract fun bindPhotosPageFragment(): PhotosPageFragment

}
