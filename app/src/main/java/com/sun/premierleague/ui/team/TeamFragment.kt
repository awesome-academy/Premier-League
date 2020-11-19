package com.sun.premierleague.ui.team

import android.view.View
import androidx.core.os.bundleOf
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseFragment
import com.sun.premierleague.data.model.Coache
import com.sun.premierleague.data.model.Player
import com.sun.premierleague.data.model.TeamItem
import com.sun.premierleague.utils.RepositoryFactory
import com.sun.premierleague.utils.loadImage
import com.sun.premierleague.utils.showToast
import kotlinx.android.synthetic.main.fragment_detail_team.*

class TeamFragment : BaseFragment(), TeamContact.View {

    private var presenter: TeamPresenter? = null
    private val adapterGoalkeeper = TeamAdapter()
    private val adapterDefender = TeamAdapter()
    private val adapterMidfielder = TeamAdapter()
    private val adapterForwarder = TeamAdapter()

    override val layoutResource get() = R.layout.fragment_detail_team

    override fun initData() {
        initAdapter()
        initPresenter()
        initCollapsingToolbar()
        arguments?.getString(BUNDLE_ID_TEAM)?.let {
            presenter?.getTeamInformation(it)
        }
    }

    private fun initAdapter() {
        recyclerGoalkeeper.adapter = adapterGoalkeeper
        recyclerPlayerDefend.adapter = adapterDefender
        recyclerPlayerMidfield.adapter = adapterMidfielder
        recyclerPlayerForward.adapter = adapterForwarder
    }

    private fun initPresenter() {
        val context = context ?: return
        val repository = RepositoryFactory.getRepository(context)
        presenter = TeamPresenter(this, repository)
    }

    private fun initCollapsingToolbar() {
        val collapsingToolbarLayout =
            collapsingToolbarTeam as CollapsingToolbarLayout
        val appBarLayout = appBarTeam as AppBarLayout
        var isShow = true
        var scrollRange = -1
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->
            if (scrollRange == -1) {
                scrollRange = barLayout?.totalScrollRange!!
            }
            if (scrollRange + verticalOffset == 0) {
                collapsingToolbarLayout.title = textDetailTeam.text
                isShow = true
            } else if (isShow) {
                collapsingToolbarLayout.title = " "
                isShow = false
            }
        })
    }

    override fun showTeam(data: List<TeamItem>) {
        textDetailTeam.text = data.first().teamName
        imageDetailTeam.loadImage(data.first().teamBadge)
    }

    override fun showCoach(coache: List<Coache>) {
        if (coache.isEmpty()) {
            view?.context?.showToast(R.string.err_no_coach)
            return
        }
        val coachOne = coache.first()
        textNameCoachOne.text = coachOne.coachName
        textInfoCoachOne.text = String.format(
            getString(R.string.text_info_coach_format),
            coachOne.coachAge,
            coachOne.coachCountry
        )
        if (coache.size > 1) {
            val coachTwo = coache[1]
            textNameCoachTwo.visibility = View.VISIBLE
            textInfoCoachTwo.visibility = View.VISIBLE
            textNameCoachTwo.text = coachTwo.coachName
            textInfoCoachTwo.text = String.format(
                getString(R.string.text_info_coach_format),
                coachTwo.coachAge,
                coachTwo.coachCountry
            )
        } else {
            imageCoachTwo.visibility = View.INVISIBLE
            textNameCoachTwo.visibility = View.INVISIBLE
            textInfoCoachTwo.visibility = View.INVISIBLE
        }
    }

    override fun showGoalkeeper(goalkeepers: List<Player>) {
        if (goalkeepers.isEmpty()) {
            view?.context?.showToast(getString(R.string.err_no_goalkeeper))
            return
        }
        adapterGoalkeeper.replaceData(goalkeepers)
        recyclerGoalkeeper.scrollToPosition(0)
    }

    override fun showDefender(defenders: List<Player>) {
        if (defenders.isEmpty()) {
            view?.context?.showToast(getString(R.string.err_no_defender))
            return
        }
        adapterDefender.replaceData(defenders)
        recyclerPlayerDefend.scrollToPosition(0)
    }

    override fun showMidfielder(midfielders: List<Player>) {
        if (midfielders.isEmpty()) {
            view?.context?.showToast(getString(R.string.err_no_midfielder))
            return
        }
        adapterMidfielder.replaceData(midfielders)
        recyclerPlayerMidfield.scrollToPosition(0)
    }

    override fun showForwarder(forwarders: List<Player>) {
        if (forwarders.isEmpty()) {
            view?.context?.showToast(getString(R.string.err_no_forwarder))
            return
        }
        adapterForwarder.replaceData(forwarders)
        recyclerPlayerForward.scrollToPosition(0)
    }

    override fun showError(error: Any) {
        view?.context?.showToast(error)
    }

    companion object {
        private const val BUNDLE_ID_TEAM = "BUNDLE_ID_TEAM"
        fun getInstance(idTeam: String) = TeamFragment().apply {
            arguments = bundleOf(BUNDLE_ID_TEAM to idTeam)
        }
    }
}
