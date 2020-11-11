package com.sun.premierleague.ui.sample.activity

import android.os.Bundle
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseActivity

class SampleActivity : BaseActivity(), SampleContact.View {
    /***
     * Note: Create xml activity in file Manifests.xml and replace setContentView
     * */
    private var presenter: SampleContact.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initPresenter() {
        presenter = SamplePresenter(this)
    }

    companion object {
        val TAG: String = SampleActivity::class.java.simpleName.toString()
    }
}
