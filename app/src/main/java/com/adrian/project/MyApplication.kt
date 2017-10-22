package com.adrian.project

import android.app.Activity
import android.app.Application
import com.adrian.project.di.DaggerAppComponent
import com.mapbox.mapboxsdk.Mapbox
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


/**
 * Created by cadri on 2017. 08. 03..0
 */

class MyApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        Mapbox.getInstance(this, "pk.eyJ1IjoiYWRyaWFuMTA3IiwiYSI6ImNqOTJzcjVvajExZW0ycXA2bjhwcGVkYzIifQ.YjsKt2q7zmkEy1A0XcPJlA");
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

}