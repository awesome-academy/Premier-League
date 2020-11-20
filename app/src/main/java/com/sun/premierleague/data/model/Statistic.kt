package com.sun.premierleague.data.model

import android.os.Parcelable
import com.sun.premierleague.utils.LineupConst.AWAY
import com.sun.premierleague.utils.LineupConst.HOME
import kotlinx.android.parcel.Parcelize
import org.json.JSONObject

@Parcelize
data class Statistic(
    val type: String,
    val home: String,
    val away: String
) : Parcelable {
    constructor(jsonObject: JSONObject) : this(
        jsonObject.getString(TYPE),
        jsonObject.getString(HOME),
        jsonObject.getString(AWAY)
    )

    companion object {
        const val TYPE = "type"
    }
}
