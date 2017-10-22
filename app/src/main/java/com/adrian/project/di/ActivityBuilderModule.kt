package com.adrian.project.di

import com.adrian.kotlinrecyclerviewdagger.main.di.ActivityScope
import com.adrian.project.ui.main.MapPageActivity
import com.adrian.project.ui.main.di.MainModule
import com.adrian.project.ui.main.view.MainActivity
import com.adrian.project.ui.mappage.di.MapPageFragmentBuilderModule
import com.adrian.project.ui.mappage.di.MapPageModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cadri on 2017. 08. 03..
 */

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MapPageModule::class, MapPageFragmentBuilderModule::class))
    abstract fun bindMapPageActivity(): MapPageActivity

}