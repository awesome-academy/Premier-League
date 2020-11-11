package com.sun.premierleague.data.source

import com.sun.premierleague.data.model.MatchItem
import com.sun.premierleague.data.model.StatItem
import com.sun.premierleague.data.model.TeamItem
import com.sun.premierleague.data.model.Time
import com.sun.premierleague.data.source.remote.OnDataLoadedCallback

class FootballRepository private constructor(
    private val remote: FootballDataSource.Remote
) : FootballDataSource.Remote {
    override fun getMatch(time: Time, callback: OnDataLoadedCallback<List<MatchItem>>) {
        remote.getMatch(time, callback)
    }

    override fun getTeam(idTeam: String, callback: OnDataLoadedCallback<List<TeamItem>>) {
        remote.getTeam(idTeam, callback)
    }

    override fun getStat(callback: OnDataLoadedCallback<List<StatItem>>) {
        remote.getStat(callback)
    }

    companion object {
        private var instance: FootballRepository? = null

        fun getInstance(remote: FootballDataSource.Remote) {
            instance ?: FootballRepository(remote).also { instance = it }
        }
    }
}
