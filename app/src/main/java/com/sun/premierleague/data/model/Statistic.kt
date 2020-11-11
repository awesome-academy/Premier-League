package com.sun.premierleague.data.model

import com.sun.premierleague.utils.LineupConst.AWAY
import com.sun.premierleague.utils.LineupConst.HOME
import org.json.JSONObject

data class Statistic(
    val type: String,
    val home: String,
    val away: String
) {
    constructor(jsonObject: JSONObject) : this(
        jsonObject.getString(TYPE),
        jsonObject.getString(HOME),
        jsonObject.getString(AWAY)
    )

    companion object {
        const val TYPE = "type"
    }
}
