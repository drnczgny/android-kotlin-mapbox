package com.adrian.project.ui.mappage.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.adrian.project.ui.mappage.subpages.allmappage.view.SRAllMapPageFragment

/**
 * Created by cadri on 2017. 08. 05..
 */

class MapViewPagerAdapter
constructor(val fm: FragmentManager, val mapViewPagerDataModel: MapViewPagerDataModel) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return mapViewPagerDataModel.fragmentList().get(0)
            1 -> return mapViewPagerDataModel.fragmentList().get(1)
            2 -> return mapViewPagerDataModel.fragmentList().get(2)
            else -> throw UnsupportedOperationException() as Throwable
        }
        return SRAllMapPageFragment.newInstance()
    }

    override fun getCount(): Int {
        return mapViewPagerDataModel.fragmentList().size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mapViewPagerDataModel.titleList().get(position)
    }
}