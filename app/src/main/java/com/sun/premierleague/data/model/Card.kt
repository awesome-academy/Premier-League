package com.sun.premierleague.data.model

import com.sun.premierleague.utils.MatchConst.INFO
import com.sun.premierleague.utils.MatchConst.TIME
import org.json.JSONObject

data class Card(
    val time: String,
    val homeFault: String,
    val card: String,
    val awayFault: String,
    val info: String,
) {
    constructor(jsonObject: JSONObject) : this(
        jsonObject.getString(TIME),
        jsonObject.getString(HOME_FAULT),
        jsonObject.getString(CARD),
        jsonObject.getString(AWAY_FAULT),
        jsonObject.getString(INFO),
    )

    companion object {
        const val HOME_FAULT = "home_fault"
        const val CARD = "card"
        const val AWAY_FAULT = "away_fault"
    }
}
