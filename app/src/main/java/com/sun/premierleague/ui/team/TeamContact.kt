package com.sun.premierleague.ui.team

import com.sun.premierleague.base.BasePresenter
import com.sun.premierleague.base.BaseView
import com.sun.premierleague.data.model.Coache
import com.sun.premierleague.data.model.Player
import com.sun.premierleague.data.model.TeamItem

interface TeamContact {
    interface View : BaseView {
        fun showTeam(teams: List<TeamItem>)
        fun showCoach(coaches: List<Coache>)
        fun showGoalkeeper(goalkeeper: List<Player>)
        fun showDefender(defender: List<Player>)
        fun showMidfielder(midfielder: List<Player>)
        fun showForwarder(forwarder: List<Player>)
        fun showError(error: Any)
    }

    interface Presenter : BasePresenter {
        fun getTeamInformation(idTeam: String)
    }
}
