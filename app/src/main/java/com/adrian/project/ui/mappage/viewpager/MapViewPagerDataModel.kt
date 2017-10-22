package com.adrian.project.ui.mappage.viewpager

import android.support.v4.app.Fragment
import com.adrian.project.ui.mappage.subpages.allmappage.view.SRAllMapPageFragment
import com.adrian.project.ui.mappage.subpages.favoritesmappage.view.SRFavoritesMapPageFragment
import com.adrian.project.ui.mappage.subpages.photospage.PhotosPageFragment

/**
 * Created by cadri on 2017. 08. 05..
 */

class MapViewPagerDataModel {

    fun titleList() = listOf<String>("All", "Favorites", "Photos")

    fun fragmentList() = listOf<Fragment>(
            SRAllMapPageFragment.newInstance(),
            SRFavoritesMapPageFragment.newInstance(),
            PhotosPageFragment.newInstance())
}
