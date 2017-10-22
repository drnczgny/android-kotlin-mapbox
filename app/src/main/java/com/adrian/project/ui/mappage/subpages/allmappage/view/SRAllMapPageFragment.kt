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
import com.adrian.project.ui.mappage.subpages.allmappage.view.SRAllMapPageFragment.name.TAG
import com.adrian.project.ui.mappage.subpages.allmappage.viewmodel.SRAllMapPageViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class SRAllMapPageFragment : Fragment(), SRAllMapPageRouter {

    @Inject
    lateinit var viewModel: SRAllMapPageViewModel

    lateinit var binding: FragmentSrAllMapPageBinding

    companion object {
        fun newInstance(): SRAllMapPageFragment {
            val fragment = SRAllMapPageFragment()
            return fragment
        }
    }

    object name {
        val TAG = SRAllMapPageFragment::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        Log.i(TAG, "onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel.onCreateView()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sr_all_map_page, container, false)
        val view = binding.getRoot()
        binding?.viewModel = viewModel
        binding?.executePendingBindings()

        return view
    }

    override fun onDestroy() {
        viewModel.onDestroy()
        super.onDestroy()
    }

    fun getLayoutId() = R.layout.fragment_sr_all_map_page

    fun getVariableId(): Int {
        return BR.viewModel
    }
}
