package com.sun.premierleague.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DiagramTeam(
    val diagrams : List<Diagram>
) : Parcelable {
}
