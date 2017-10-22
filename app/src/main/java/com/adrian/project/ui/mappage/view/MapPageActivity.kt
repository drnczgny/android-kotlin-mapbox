package com.adrian.project.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.adrian.project.BR
import com.adrian.project.R
import com.adrian.project.databinding.ActivityMapPageBinding
import com.adrian.project.ui.mappage.subpages.postspage.MapPageRouter
import com.adrian.project.ui.mappage.viewmodel.MapPageViewModel
import com.adrian.project.ui.mappage.viewpager.MapViewPagerAdapter
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MapPageActivity : AppCompatActivity(), MapPageRouter, HasSupportFragmentInjector {

    @Inject lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject lateinit var mapPageViewModel: MapPageViewModel

    @Inject lateinit var mapViewPagerAdapter: MapViewPagerAdapter

    lateinit var binding: ActivityMapPageBinding
    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        bind()
        setSupportActionBar(binding.toolbar)
        setupViewPager()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    fun bind() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding?.viewModel = this.mapPageViewModel
        binding?.executePendingBindings()
    }

    fun setupViewPager() {
        this.tabLayout = binding.tabLayout
        this.viewPager = binding.viewPager
        viewPager.adapter = mapViewPagerAdapter
        tabLayout.setupWithViewPager(this.viewPager)
    }

    fun getLayoutId() = R.layout.activity_map_page

    fun getVariableId(): Int {
        return BR.viewModel
    }
}
