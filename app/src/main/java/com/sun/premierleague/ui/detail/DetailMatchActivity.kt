package com.sun.premierleague.ui.detail

import android.os.Bundle
import android.view.WindowManager
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseActivity

class DetailMatchActivity : BaseActivity(), DetailMatchContact.View {

    private var presenter: DetailMatchContact.Presenter? = null
    override val layoutResource: Int
        get() = R.layout.activity_detail_match

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        changeSizeWindow()
    }

    override fun initComponents() {}

    private fun changeSizeWindow() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
}
