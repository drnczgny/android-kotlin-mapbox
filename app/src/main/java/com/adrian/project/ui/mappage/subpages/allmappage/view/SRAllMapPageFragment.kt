package com.adrian.project.ui.mappage.subpages.allmappage.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adrian.project.BR
import com.adrian.project.R
import com.adrian.project.databinding.FragmentSrAllMapPageBinding
import com.adrian.project.ui.mappage.subpages.allmappage.viewmodel.SRAllMapPageViewModel
import com.adrian.project.ui.mappage.subpages.map.MapController
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class SRAllMapPageFragment : Fragment(), SRAllMapPageRouter {

    @Inject
    lateinit var viewModel: SRAllMapPageViewModel

    @Inject
    lateinit var mapController: MapController

    lateinit var binding: FragmentSrAllMapPageBinding

    companion object {
        fun newInstance(): SRAllMapPageFragment {
            val fragment = SRAllMapPageFragment()
            return fragment
        }
    }

    object logging {
        val TAG = SRAllMapPageFragment::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        Log.i(logging.TAG, "onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel.onCreateView()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sr_all_map_page, container, false)
        val view = binding.getRoot()
        binding?.viewModel = viewModel
        binding?.executePendingBindings()

        binding.mapView.onCreate(savedInstanceState);

        mapController.setMap(binding.mapView)

        return view
    }

    private fun addMarker(lat: Double, lon: Double) {
        binding.mapView.getMapAsync(OnMapReadyCallback { mapboxMap ->
            mapboxMap.addMarker(MarkerOptions()
                    .position(LatLng(lat, lon))
                    .title(getString(R.string.draw_marker_options_title))
                    .snippet(getString(R.string.draw_marker_options_snippet)))
        })
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
        Log.e(logging.TAG, "    override fun onPause() {\n ...");
        super.onPause()
        binding.mapView.onPause();
    }

    override fun onStop() {
        Log.e(logging.TAG, "onStop ...");
        super.onStop()
        binding.mapView.onStop();
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.e(logging.TAG, "onSaveInstanceState ...");
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState);
    }

    override fun onLowMemory() {
        Log.e(logging.TAG, "onLowMemory ...");
        super.onLowMemory()
        binding.mapView.onLowMemory();
    }

    override fun onDestroy() {
        Log.e(logging.TAG, "onDestroy ...");
        viewModel.onDestroy()
        super.onDestroy()
        binding.mapView.onDestroy();
    }


    fun getLayoutId() = R.layout.fragment_sr_all_map_page

    fun getVariableId(): Int {
        return BR.viewModel
    }
}
