package com.sun.premierleague.data.model

import com.sun.premierleague.utils.LineupConst.LINEUP_NUMBER
import com.sun.premierleague.utils.LineupConst.LINEUP_PLAYER
import com.sun.premierleague.utils.LineupConst.LINEUP_POSITION
import com.sun.premierleague.utils.LineupConst.PLAYER_KEY
import org.json.JSONObject

data class MissingPlayer(
    val lineupPlayer: String,
    val lineupNumber: String,
    val lineupPosition: String,
    val playerKey: String
) {
    constructor(jsonObject: JSONObject) : this(
        jsonObject.getString(LINEUP_PLAYER),
        jsonObject.getString(LINEUP_NUMBER),
        jsonObject.getString(LINEUP_POSITION),
        jsonObject.getString(PLAYER_KEY)
    )
}
