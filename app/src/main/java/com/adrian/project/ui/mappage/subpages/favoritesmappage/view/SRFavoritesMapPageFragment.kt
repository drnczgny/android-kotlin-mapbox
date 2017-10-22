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
import com.mapbox.mapboxsdk.Mapbox
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject



class SRFavoritesMapPageFragment : Fragment(), SRFavoritesMapPageRouter {

    @Inject
    lateinit var viewModel: SRFavoritesMapViewModel

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

        binding.mapView.onCreate(savedInstanceState);

        return view
    }

    override fun onStart() {
        Log.e(logging.TAG, "onStart ...");
        super.onStart()
        binding.mapView.onStart();
    }

    override fun onResume() {
        Log.e(logging.TAG, "onResume ...");
        super.onResume()
        binding.mapView.onResume();
    }

    override fun onPause() {
        Log.e(logging.TAG, "onPause ...");
        super.onPause()
        binding.mapView.onPause();
    }

    override fun onStop() {
        Log.e(logging.TAG, "onStop ...");
        super.onStop()
        binding.mapView.onStop();
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.e(SRAllMapPageFragment.logging.TAG, "onSaveInstanceState ...");
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState);
    }

    override fun onLowMemory() {
        Log.e(logging.TAG, "onLowMemory ...");
        binding.mapView.onLowMemory();
        super.onLowMemory()
    }

    override fun onDestroy() {
        Log.e(logging.TAG, "onDestroy ...");
        viewModel.onDestroy()
        binding.mapView.onDestroy();
        super.onDestroy()
    }

    fun getLayoutId() = R.layout.fragment_sr_favorites_map_page

    fun getVariableId(): Int {
        return BR.viewModel
    }
}
