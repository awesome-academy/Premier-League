package com.sun.premierleague.data.model

import com.sun.premierleague.utils.LineupConst.AWAY
import com.sun.premierleague.utils.LineupConst.HOME
import org.json.JSONObject

data class Lineup(
    val away: Away,
    val home: Home
) {
    constructor(jsonObject: JSONObject) : this(
        jsonObject.getJSONObject(AWAY).let(::Away),
        jsonObject.getJSONObject(HOME).let(::Home)
    )
}
