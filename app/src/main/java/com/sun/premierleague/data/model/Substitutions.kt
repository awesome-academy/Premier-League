package com.sun.premierleague.data.model

import android.os.Parcelable
import com.sun.premierleague.utils.LineupConst.AWAY
import com.sun.premierleague.utils.LineupConst.HOME
import com.sun.premierleague.utils.map
import kotlinx.android.parcel.Parcelize
import org.json.JSONObject

@Parcelize
data class Substitutions(
    val home: List<SubtitutionItem>,
    val away: List<SubtitutionItem>
) : Parcelable {
    constructor(jsonObject: JSONObject) : this(
        jsonObject.getJSONArray(HOME).map(::SubtitutionItem),
        jsonObject.getJSONArray(AWAY).map(::SubtitutionItem)
    )
}
