package com.sun.premierleague.ui.team

import com.sun.premierleague.R
import com.sun.premierleague.data.model.Player
import com.sun.premierleague.data.model.TeamItem
import com.sun.premierleague.data.source.FootballRepository
import com.sun.premierleague.data.source.remote.OnDataLoadedCallback
import com.sun.premierleague.utils.*
import java.lang.Exception

class TeamPresenter(
    private val view: TeamContact.View,
    private val repository: FootballRepository
) : TeamContact.Presenter {

    override fun getTeamInformation(idTeam: String) {
        repository.getTeam(idTeam, object : OnDataLoadedCallback<List<TeamItem>> {
            override fun onSuccess(data: List<TeamItem>) {
                if (data.isEmpty()) {
                    view.showError(R.string.err_no_data)
                    return
                }
                view.showTeam(data)

                val coaches = data.first().coaches
                view.showCoach(coaches)

                val players = data.first().players
                if (players.isEmpty()) {
                    view.showError(R.string.err_no_player)
                    return
                }
                val defenders = players.filter { item -> item.isDefender() }
                val forwarders = players.filter { item -> item.isForwarder() }
                val goalkeepers = players.filter { item -> item.isGoalkeeper() }
                val midfielders = players.filter { item -> item.isMidfielder() }
                view.run {
                    showGoalkeeper(goalkeepers)
                    showDefender(defenders)
                    showMidfielder(midfielders)
                    showForwarder(forwarders)
                }
            }

            override fun onFailure(exception: Exception?) {
                exception?.let {
                    view.showError(it)
                }
            }
        })
    }
}
