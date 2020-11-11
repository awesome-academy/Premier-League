package com.sun.premierleague.ui.sample.fragment

import android.os.Bundle
import android.view.View
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseFragment

class SampleFragment : BaseFragment(), SampleContact.View {
    /***
     * Note: replace configView
     * */
    private var presenter: SampleContact.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun configView(): Int = R.layout.activity_main

    override fun initPresenter() {
        presenter = SampleFragmentPresenter(this)
    }

    override fun initData() {
        // Handle Logic
    }

    companion object {
        val TAG: String = SampleFragment::class.java.simpleName.toString()
        private var instance: SampleFragment? = null
        fun getInstance(): SampleFragment = instance ?: synchronized(this) {
            instance ?: SampleFragment().also { instance = it }
        }
    }
}
