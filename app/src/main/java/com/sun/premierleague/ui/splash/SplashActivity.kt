package com.sun.premierleague.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun.premierleague.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(HomeActivity.getIntent(this))
        finish()
    }
}
