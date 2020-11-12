package com.sun.premierleague.ui.main

import android.content.Context
import android.content.Intent
import com.sun.premierleague.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun initPresenter() {
        TODO("Not yet implemented")
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
