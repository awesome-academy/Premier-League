package com.sun.premierleague.data.source

import com.sun.premierleague.data.model.MatchItem
import com.sun.premierleague.data.model.StatItem
import com.sun.premierleague.data.model.TeamItem
import com.sun.premierleague.data.model.Time
import com.sun.premierleague.data.source.remote.OnDataLoadedCallback

interface FootballDataSource {
    interface Remote {
        fun getMatch(time: Time, callback: OnDataLoadedCallback<List<MatchItem>>)
        fun getTeam(idTeam: String, callback: OnDataLoadedCallback<List<TeamItem>>)
        fun getStat(callback: OnDataLoadedCallback<List<StatItem>>)
    }
}
