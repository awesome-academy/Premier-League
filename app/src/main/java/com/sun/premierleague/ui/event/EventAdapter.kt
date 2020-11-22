package com.sun.premierleague.ui.event

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseAdapter
import com.sun.premierleague.base.BaseViewHolder
import com.sun.premierleague.data.model.DetailEvent

class EventAdapter : BaseAdapter<DetailEvent>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<DetailEvent> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview_event, parent, false)
        return EventViewHolder(view)
    }
}
