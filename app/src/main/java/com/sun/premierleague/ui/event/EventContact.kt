package com.sun.premierleague.ui.event

import com.sun.premierleague.base.BasePresenter
import com.sun.premierleague.base.BaseView
import com.sun.premierleague.data.model.DetailEvent
import com.sun.premierleague.data.model.Event

interface EventContact {
    interface View : BaseView {
        fun showEvents(detailEvents: List<DetailEvent>)
        fun showError(resId: Int)
    }

    interface Presenter : BasePresenter {
        fun getTimeLineEvent(event: Event?)
    }
}
