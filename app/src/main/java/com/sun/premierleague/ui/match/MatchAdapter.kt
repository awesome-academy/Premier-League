package com.sun.premierleague.ui.match

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseAdapter
import com.sun.premierleague.base.BaseViewHolder
import com.sun.premierleague.data.model.MatchItem

class MatchAdapter(
    private var onItemClick: (MatchItem) -> Unit = { _ -> }
) : BaseAdapter<MatchItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MatchItem> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview_match, parent, false)
        return MatchViewHolder(view, onItemClick)
    }
}
