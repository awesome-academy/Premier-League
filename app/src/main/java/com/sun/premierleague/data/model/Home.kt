package com.sun.premierleague.data.model

import android.os.Parcelable
import com.sun.premierleague.utils.LineupConst.COACH
import com.sun.premierleague.utils.LineupConst.MISSING_PLAYERS
import com.sun.premierleague.utils.LineupConst.STARTING_LINEUPS
import com.sun.premierleague.utils.LineupConst.SUBSTITUTES
import com.sun.premierleague.utils.map
import kotlinx.android.parcel.Parcelize
import org.json.JSONObject

@Parcelize
data class Home(
    val coach: List<Coach>,
    val missingPlayers: List<MissingPlayer>,
    val startingLineups: List<StartingLineup>,
    val substitutes: List<Substitute>
) : Parcelable {
    constructor(jsonObject: JSONObject) : this(
        jsonObject.getJSONArray(COACH).map(::Coach),
        jsonObject.getJSONArray(MISSING_PLAYERS).map(::MissingPlayer),
        jsonObject.getJSONArray(STARTING_LINEUPS).map(::StartingLineup),
        jsonObject.getJSONArray(SUBSTITUTES).map(::Substitute)
    )
}
