package com.sun.premierleague.data.source

import com.sun.premierleague.data.model.*
import com.sun.premierleague.data.source.remote.OnDataLoadedCallback

class FootballRepository private constructor(
    private val local: FootballDataSource.Local,
    private val remote: FootballDataSource.Remote
) : FootballDataSource.Remote, FootballDataSource.Local {
    override fun getMatch(time: Time, callback: OnDataLoadedCallback<List<MatchItem>>) {
        remote.getMatch(time, callback)
    }

    override fun getTeam(idTeam: String, callback: OnDataLoadedCallback<List<TeamItem>>) {
        remote.getTeam(idTeam, callback)
    }

    override fun getStat(callback: OnDataLoadedCallback<List<StatItem>>) {
        remote.getStat(callback)
    }

    override fun getFootballNotifications(): List<MatchNotification> =
        local.getFootballNotifications()

    override fun getItemFootballNotification(idMatch: String): MatchNotification =
        local.getItemFootballNotification(idMatch)

    override fun addFootballNotification(matchNotification: MatchNotification): Boolean =
        local.addFootballNotification(matchNotification)

    override fun deleteFootballNotification(idMatch: String): Boolean =
        local.deleteFootballNotification(idMatch)

    companion object {
        private var instance: FootballRepository? = null

        fun getInstance(local: FootballDataSource.Local, remote: FootballDataSource.Remote) {
            instance ?: FootballRepository(local, remote).also { instance = it }
        }
    }
}
