package com.sun.premierleague.ui.stats

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseAdapter
import com.sun.premierleague.base.BaseViewHolder
import com.sun.premierleague.data.model.StatItem

class StatsAdapter : BaseAdapter<StatItem>() {

    var onItemClick: (StatItem) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<StatItem> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview_stats, parent, false)
        return StatsViewHolder(view, onItemClick)
    }
}
