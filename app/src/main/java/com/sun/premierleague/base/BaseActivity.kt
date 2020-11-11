package com.sun.premierleague.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun.premierleague.utils.showToast

abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected abstract fun initPresenter()

    override fun showMessage(data: Any) {
        baseContext.showToast(data)
    }
}
