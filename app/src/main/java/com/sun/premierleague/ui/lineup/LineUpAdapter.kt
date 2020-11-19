package com.sun.premierleague.ui.lineup

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseAdapter
import com.sun.premierleague.base.BaseViewHolder

class LineUpAdapter : BaseAdapter<String>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview_line_up, parent, false)
        return LineUpViewHolder(view)
    }
}
