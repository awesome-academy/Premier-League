package com.sun.premierleague.ui.detail

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseActivity
import com.sun.premierleague.data.model.Event
import com.sun.premierleague.data.model.MatchItem
import com.sun.premierleague.ui.event.EventFragment
import com.sun.premierleague.ui.lineup.LineUpFragment
import com.sun.premierleague.utils.MatchConst
import com.sun.premierleague.utils.loadImage
import kotlinx.android.synthetic.main.activity_detail_match.*

class DetailMatchActivity : BaseActivity(), DetailMatchContact.View {

    private var presenter: DetailMatchContact.Presenter? = null
    private val matchItem: MatchItem? by lazy {
        intent?.getParcelableExtra(MatchConst.EXTRA_MATCH_ITEM)
    }
    private val fragments = mutableListOf<Fragment>()
    private val adapter: DetailMatchAdapter? by lazy {
        DetailMatchAdapter(supportFragmentManager)
    }

    override val layoutResource: Int
        get() = R.layout.activity_detail_match

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        changeSizeWindow()
        initData()
        initAdapter()
        showDetailMatch()
        imageBack.setOnClickListener { finish() }
    }

    private fun initData() {
        matchItem?.let {
            if (it.matchStatus != MatchConst.FINISHED) {
                textStatusMatch.visibility = View.VISIBLE
                return
            }

            fragments.add(LineUpFragment.getInstance(it.lineup.apply {
                homeSystem = it.matchHomeTeamSystem
                awaySystem = it.matchAwayTeamSystem
                nameReferee = it.matchReferee
                nameStadium = it.matchStadium
            }))

            fragments.add(
                EventFragment.getInstance(
                    Event(it.goalscorer, it.cards, it.substitutions)
                )
            )
        }
    }

    private fun initAdapter() {
        adapter?.replaceData(fragments)
        viewPagerDetailMatch.adapter = adapter
        tabDetailMatch.setupWithViewPager(viewPagerDetailMatch)

        tabDetailMatch?.run {
            getTabAt(0)?.setIcon(R.drawable.ic_tshirt)
            getTabAt(1)?.setIcon(R.drawable.ic_event)
        }
    }

    private fun showDetailMatch() {
        matchItem?.let {
            imageRing.visibility =
                if (it.matchStatus == MatchConst.FINISHED) View.GONE else View.VISIBLE
            imageHomeTeam.loadImage(it.teamHomeBadge)
            imageWayTeam.loadImage(it.teamAwayBadge)
            textAwayTeam.text = it.matchAwayTeamName
            textHomeTeam.text = it.matchHomeTeamName
            textResult.text =
                getString(R.string.text_score, it.matchHomeTeamScore, it.matchAwayTeamScore)
            textTimeMatch.text =
                getString(R.string.title_address_match, it.matchStadium, it.matchDate, it.matchTime)
        }
    }

    override fun initComponents() {}

    private fun changeSizeWindow() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
}
