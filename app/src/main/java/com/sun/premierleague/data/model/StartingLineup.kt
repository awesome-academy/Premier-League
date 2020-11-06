package com.sun.premierleague.data.model

import com.sun.premierleague.utils.LineupConst
import org.json.JSONObject

data class StartingLineup(
    val lineupPlayer: String,
    val lineupNumber: String,
    val lineupPosition: String,
    val playerKey: String
){
    constructor(jsonObject: JSONObject) : this(
        jsonObject.getString(LineupConst.LINEUP_PLAYER),
        jsonObject.getString(LineupConst.LINEUP_NUMBER),
        jsonObject.getString(LineupConst.LINEUP_POSITION),
        jsonObject.getString(LineupConst.PLAYER_KEY)
    )
}
