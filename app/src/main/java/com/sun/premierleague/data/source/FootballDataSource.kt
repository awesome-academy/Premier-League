package com.sun.premierleague.data.source

import com.sun.premierleague.data.model.*
import com.sun.premierleague.data.source.remote.OnDataLoadedCallback

interface FootballDataSource {
    interface Local {
        fun getFootballNotifications(): List<MatchNotification>
        fun getItemFootballNotification(idMatch: String): MatchNotification
        fun addFootballNotification(matchNotification: MatchNotification): Boolean
        fun deleteFootballNotification(idMatch: String): Boolean
    }

    interface Remote {
        fun getMatch(time: Time, callback: OnDataLoadedCallback<List<MatchItem>>)
        fun getTeam(idTeam: String, callback: OnDataLoadedCallback<List<TeamItem>>)
        fun getStat(callback: OnDataLoadedCallback<List<StatItem>>)
    }
}
