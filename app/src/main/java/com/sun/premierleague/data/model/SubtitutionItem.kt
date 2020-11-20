package com.sun.premierleague.data.model

import android.os.Parcelable
import com.sun.premierleague.utils.MatchConst.TIME
import kotlinx.android.parcel.Parcelize
import org.json.JSONObject

@Parcelize
data class SubtitutionItem(
    val time: String,
    val substitution: String
) : Parcelable {
    constructor(jsonObject: JSONObject) : this(
        jsonObject.getString(TIME),
        jsonObject.getString(SUBSTITUTION)
    )

    companion object {
        const val SUBSTITUTION = "substitution"
    }
}
