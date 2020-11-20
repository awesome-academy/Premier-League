package com.sun.premierleague.data.model

import android.os.Parcelable
import com.sun.premierleague.utils.LineupConst.LINEUP_NUMBER
import com.sun.premierleague.utils.LineupConst.LINEUP_PLAYER
import com.sun.premierleague.utils.LineupConst.LINEUP_POSITION
import com.sun.premierleague.utils.LineupConst.PLAYER_KEY
import kotlinx.android.parcel.Parcelize
import org.json.JSONObject

@Parcelize
data class Substitute(
    val lineupPlayer: String,
    val lineupNumber: String,
    val lineupPosition: String,
    val playerKey: String
) : Parcelable {
    constructor(jsonObject: JSONObject) : this(
        jsonObject.getString(LINEUP_PLAYER),
        jsonObject.getString(LINEUP_NUMBER),
        jsonObject.getString(LINEUP_POSITION),
        jsonObject.getString(PLAYER_KEY)
    )
}
