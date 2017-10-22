package com.adrian.project.ui.mappage.recyclerview

import android.databinding.BindingAdapter
import android.support.v4.view.ViewPager


/**
 * Created by cadri on 2017. 10. 22..
 */



@BindingAdapter(value = *arrayOf("requestTransparentRegion"))
fun  setRequestTransparentRegion(viewPager: ViewPager, value: Int) {
    viewPager.requestTransparentRegion(viewPager);
}