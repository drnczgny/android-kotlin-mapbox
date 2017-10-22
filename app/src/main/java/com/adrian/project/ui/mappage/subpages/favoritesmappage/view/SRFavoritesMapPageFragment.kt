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
import com.adrian.project.ui.mappage.subpages.favoritesmappage.view.SRFavoritesMapPageFragment.name.TAG
import com.adrian.project.ui.mappage.subpages.favoritesmappage.viewmodel.SRFavoritesMapViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SRFavoritesMapPageFragment : Fragment(), SRFavoritesMapPageRouter {

    @Inject
    lateinit var viewModel: SRFavoritesMapViewModel

    lateinit var binding: FragmentSrFavoritesMapPageBinding

    companion object {
        fun newInstance(): SRFavoritesMapPageFragment {
            val fragment = SRFavoritesMapPageFragment()
            return fragment
        }
    }

    object name {
        val TAG = SRFavoritesMapPageFragment::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        Log.i(TAG, "onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel.toString()
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        val view = binding.getRoot()
        binding?.viewModel = viewModel
        binding?.executePendingBindings()

        return view
    }

    fun getLayoutId() = R.layout.fragment_sr_favorites_map_page

    fun getVariableId(): Int {
        return BR.viewModel
    }
}
