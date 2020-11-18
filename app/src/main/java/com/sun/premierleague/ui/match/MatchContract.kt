package com.sun.premierleague.ui.match

import com.sun.premierleague.base.BasePresenter
import com.sun.premierleague.base.BaseView
import com.sun.premierleague.data.model.MatchItem
import com.sun.premierleague.data.model.Time

interface MatchContract {
    interface View : BaseView {
        fun showMatch(matches: List<MatchItem>)
        fun showError(error: String)
    }

    interface Presenter : BasePresenter {
        fun getMatchInformation(time: Time)
    }
}
