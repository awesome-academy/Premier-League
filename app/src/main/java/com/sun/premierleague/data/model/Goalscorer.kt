package com.sun.premierleague.data.model

import com.sun.premierleague.utils.MatchConst.INFO
import com.sun.premierleague.utils.MatchConst.TIME
import org.json.JSONObject

data class Goalscorer(
    val time: String,
    val homeScorer: String,
    val homeScorerId: String,
    val homeAssist: String,
    val homeAssistId: String,
    val score: String,
    val awayScorer: String,
    val awayScorerId: String,
    val awayAssist: String,
    val awayAssistId: String,
    val info: String
) {
    constructor(jsonObject: JSONObject) : this(
        jsonObject.getString(TIME),
        jsonObject.getString(HOME_SCORE),
        jsonObject.getString(HOME_SCORE_ID),
        jsonObject.getString(HOME_ASSIST),
        jsonObject.getString(HOME_ASSIST_ID),
        jsonObject.getString(SCORE),
        jsonObject.getString(AWAY_SCORER),
        jsonObject.getString(AWAY_SCORER_ID),
        jsonObject.getString(AWAY_ASSIST),
        jsonObject.getString(AWAY_ASSIST_ID),
        jsonObject.getString(INFO)
    )

    companion object {
        const val HOME_SCORE = "home_scorer"
        const val HOME_SCORE_ID = "home_scorer_id"
        const val HOME_ASSIST = "home_assist"
        const val HOME_ASSIST_ID = "home_assist_id"
        const val SCORE = "score"
        const val AWAY_SCORER = "away_scorer"
        const val AWAY_SCORER_ID = "away_scorer_id"
        const val AWAY_ASSIST = "away_assist"
        const val AWAY_ASSIST_ID = "away_assist_id"
    }
}
