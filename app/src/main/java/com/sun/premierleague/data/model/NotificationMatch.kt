package com.sun.premierleague.data.model

import android.content.ContentValues

data class NotificationMatch(
    val matchId: String,
    val matchDate: String,
    val matchTime: String,
    val matchHomeTeamId: String,
    val matchHomeTeamName: String,
    val matchAwayTeamId: String,
    val matchAwayTeamName: String
) {
    fun getContentValues() = ContentValues().apply {
        put(MatchItem.MATCH_ID, matchId)
        put(MatchItem.MATCH_DATE, matchDate)
        put(MatchItem.MATCH_TIME, matchTime)
        put(MatchItem.MATCH_HOMETEAM_ID, matchHomeTeamId)
        put(MatchItem.MATCH_HOMETEAM_NAME, matchHomeTeamName)
        put(MatchItem.MATCH_AWAYTEAM_ID, matchAwayTeamId)
        put(MatchItem.MATCH_AWAYTEAM_NAME, matchAwayTeamName)
    }

    companion object {
        const val MATCH_ID = "match_id"
        const val MATCH_DATE = "match_date"
        const val MATCH_TIME = "match_time"
        const val MATCH_HOME_TEAM_ID = "match_hometeam_id"
        const val MATCH_HOME_TEAM_NAME = "match_hometeam_name"
        const val MATCH_AWAY_TEAM_NAME = "match_awayteam_name"
        const val MATCH_AWAY_TEAM_ID = "match_awayteam_id"
        const val TABLE_NAME = "football"
    }
}
