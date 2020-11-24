package com.sun.premierleague.ui.team

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseAdapter
import com.sun.premierleague.base.BaseViewHolder
import com.sun.premierleague.data.model.Player

class TeamAdapter : BaseAdapter<Player>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Player> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview_player, parent, false)
        return TeamViewHolder(view)
    }
}
