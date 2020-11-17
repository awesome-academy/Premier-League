package com.sun.premierleague.ui.detail

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail_match.*

class DetailMatchActivity : BaseActivity(), DetailMatchContact.View {

    private var presenter: DetailMatchContact.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        changeSizeWindow()
    }

    override fun initPresenter() {
        presenter = DetailMatchPresenter(this)
    }

    private fun changeSizeWindow() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
}
