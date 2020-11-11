package com.sun.premierleague.data.model

import com.sun.premierleague.utils.MatchConst.TIME
import org.json.JSONObject

data class SubtitutionItem(
    val time: String,
    val substitution: String
) {
    constructor(jsonObject: JSONObject) : this(
        jsonObject.getString(TIME),
        jsonObject.getString(SUBSTITUTION)
    )

    companion object {
        const val SUBSTITUTION = "substitution"
    }
}
