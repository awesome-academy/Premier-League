package com.sun.premierleague.ui.stats

import com.sun.premierleague.base.BasePresenter
import com.sun.premierleague.base.BaseView
import com.sun.premierleague.data.model.StatItem

interface StatsContact {
    interface View : BaseView {
        fun showStats(data: List<StatItem>)
        fun showError(error: String)
    }

    interface Presenter : BasePresenter {
        fun getStatsInformation()
    }
}
