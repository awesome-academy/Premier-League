package com.sun.premierleague.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.sun.premierleague.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                startActivity(MainActivity.getIntent(this))
                finish()
            }, DELAY_MILLIS)
        }
    }

    companion object {
        private const val DELAY_MILLIS = 1500L
    }
}
