package com.sun.premierleague.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseActivity

class HomeActivity : BaseActivity(), HomeContact.View {

    private var presenter: HomeContact.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initPresenter() {
        presenter = HomePresenter(this)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }
}
