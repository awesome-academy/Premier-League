package com.sun.premierleague.data.model

import com.sun.premierleague.utils.LineupConst.AWAY
import com.sun.premierleague.utils.LineupConst.HOME
import com.sun.premierleague.utils.map
import org.json.JSONObject

data class Substitutions(
    val home: List<SubtitutionItem>,
    val away: List<SubtitutionItem>
) {
    constructor(jsonObject: JSONObject) : this(
        jsonObject.getJSONArray(HOME).map(::SubtitutionItem),
        jsonObject.getJSONArray(AWAY).map(::SubtitutionItem)
    )
}
