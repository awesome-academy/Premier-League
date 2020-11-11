package com.sun.premierleague.data.model

import com.sun.premierleague.utils.LineupConst.COACH
import com.sun.premierleague.utils.LineupConst.MISSING_PLAYER
import com.sun.premierleague.utils.LineupConst.STARTING_LINEUPS
import com.sun.premierleague.utils.LineupConst.SUBTITUTES
import com.sun.premierleague.utils.map
import org.json.JSONObject

data class Away(
    val coach: List<Coach>,
    val missingPlayers: List<MissingPlayer>,
    val startingLineups: List<StartingLineup>,
    val substitutes: List<Substitute>
) {
    constructor(jsonObject: JSONObject) : this(
        jsonObject.getJSONArray(COACH).map(::Coach),
        jsonObject.getJSONArray(MISSING_PLAYER).map(::MissingPlayer),
        jsonObject.getJSONArray(STARTING_LINEUPS).map(::StartingLineup),
        jsonObject.getJSONArray(SUBTITUTES).map(::Substitute)
    )
}
