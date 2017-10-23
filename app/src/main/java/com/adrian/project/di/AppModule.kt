package com.adrian.project.di

import android.content.Context
import com.adrian.project.MyApplication
import com.adrian.project.R
import com.adrian.project.data.ApiService
import com.mapbox.mapboxsdk.Mapbox
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by cadri on 2017. 08. 03..
 */

@Module
class AppModule {

    @Singleton
    @Provides
    @Named("ApplicationContext")
    fun provideContext(myApplication: MyApplication): Context
            = myApplication

    @Singleton
    @Provides
    fun provideApiService()
            = ApiService()

    @Singleton
    @Provides
    fun provideMapBox(@Named("ApplicationContext") context: Context): Mapbox
            = Mapbox.getInstance(context, context.getString(R.string.map_box_token));

}