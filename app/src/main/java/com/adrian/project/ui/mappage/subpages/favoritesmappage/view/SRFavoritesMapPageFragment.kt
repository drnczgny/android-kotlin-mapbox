package com.adrian.project.ui.mappage.subpages.favoritesmappage.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adrian.project.BR
import com.adrian.project.R
import com.adrian.project.databinding.FragmentSrFavoritesMapPageBinding
import com.adrian.project.ui.mappage.subpages.allmappage.view.SRAllMapPageFragment
import com.adrian.project.ui.mappage.subpages.favoritesmappage.viewmodel.SRFavoritesMapViewModel
import com.adrian.project.ui.mappage.subpages.map.MapController
import com.mapbox.mapboxsdk.Mapbox
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject



class SRFavoritesMapPageFragment : Fragment(), SRFavoritesMapPageRouter {

    @Inject
    lateinit var viewModel: SRFavoritesMapViewModel

    @Inject
    lateinit var mapController: MapController

    @Inject
    lateinit var mapBox: Mapbox


    lateinit var binding: FragmentSrFavoritesMapPageBinding

    companion object {
        fun newInstance(): SRFavoritesMapPageFragment {
            val fragment = SRFavoritesMapPageFragment()
            return fragment
        }
    }

    object logging {
        val TAG = SRFavoritesMapPageFragment::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        Log.i(logging.TAG, "onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel.toString()
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        val view = binding.getRoot()
        binding?.viewModel = viewModel
        binding?.executePendingBindings()

        mapController.setMap(binding.mapView)
        mapController.onCreate(savedInstanceState);

        return view
    }

    override fun onStart() {
        Log.e(logging.TAG, "onStart ...");
        super.onStart()
        mapController.onStart();
    }

    override fun onResume() {
        Log.e(logging.TAG, "onResume ...");
        super.onResume()
        mapController.onResume();
    }

    override fun onPause() {
        Log.e(logging.TAG, "onPause ...");
        super.onPause()
        mapController.onPause();
    }

    override fun onStop() {
        Log.e(logging.TAG, "onStop ...");
        super.onStop()
        mapController.onStop();
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.e(SRAllMapPageFragment.logging.TAG, "onSaveInstanceState ...");
        super.onSaveInstanceState(outState)
        mapController.onSaveInstanceState(outState);
    }

    override fun onLowMemory() {
        Log.e(logging.TAG, "onLowMemory ...");
        super.onLowMemory()
        mapController.onLowMemory();
    }

    override fun onDestroy() {
        Log.e(logging.TAG, "onDestroy ...");
        viewModel.onDestroy()
        mapController.onDestroy();
        super.onDestroy()
    }

    fun getLayoutId() = R.layout.fragment_sr_favorites_map_page

    fun getVariableId(): Int {
        return BR.viewModel
    }
}
