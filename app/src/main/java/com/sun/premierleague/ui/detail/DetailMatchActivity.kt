package com.sun.premierleague.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseActivity
import com.sun.premierleague.ui.team.TeamFragment

class DetailMatchActivity : BaseActivity(), DetailMatchContact.View {

    private var presenter: DetailMatchContact.Presenter? = null

    override val layoutResource: Int
        get() = R.layout.activity_detail_match

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        changeSizeWindow()
    }

    override fun initComponents() {
        startFragmentTeam()
    }

    private fun startFragmentTeam() {
        val getData = intent?.getStringExtra(EXTRA_ID_TEAM)
        getData?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentDetailMatch, TeamFragment.getInstance(it)).commit()
        }
    }

    private fun changeSizeWindow() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

    companion object {
        private const val EXTRA_ID_TEAM = "com.sun.premierleague.ui.detail.EXTRA_ID_TEAM"
        fun getIntent(context: Context, idTeam: String) =
            Intent(context, DetailMatchActivity::class.java).putExtra(EXTRA_ID_TEAM, idTeam)
    }
}
