package com.sun.premierleague.ui.main

import android.content.Context
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseActivity
import com.sun.premierleague.ui.match.MatchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override val layoutResource: Int get() = R.layout.activity_main

    override fun initComponents() {
        bottomNavigationView.setOnNavigationItemSelectedListener(onBottomNavigation)
        bottomNavigationView.selectedItemId = R.id.menuMatch
    }

    private val onBottomNavigation =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuMatch -> openFragment(MatchFragment())
            }
            true
        }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
