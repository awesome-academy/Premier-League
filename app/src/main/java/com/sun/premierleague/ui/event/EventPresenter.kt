package com.sun.premierleague.ui.event

import com.sun.premierleague.R
import com.sun.premierleague.data.model.DetailEvent
import com.sun.premierleague.data.model.Event
import com.sun.premierleague.data.source.FootballRepository

class EventPresenter(
    private val view: EventContact.View,
    private val repository: FootballRepository
) : EventContact.Presenter {

    override fun getTimeLineEvent(event: Event?) {
        if (event == null) {
            view.showError(R.string.err_load_events)
            return
        }

        val goalscorers = event.goalScorers
        val cards = event.cards
        val substitution = event.substitutions
        val events = mutableListOf<DetailEvent>()

        events.addAll(goalscorers.map {
            DetailEvent(it).apply {
                if (it.homeScorer.isEmpty()) {
                    namePlayer = it.awayScorer
                    isHome = false
                } else {
                    namePlayer = it.homeScorer
                    isHome = true
                }
            }
        })

        events.addAll(cards.map {
            DetailEvent(it).apply {
                if (it.homeFault.isEmpty()) {
                    namePlayer = it.awayFault
                    isHome = false
                } else {
                    namePlayer = it.homeFault
                    isHome = true
                }
            }
        })

        events.addAll(substitution.home.map {
            DetailEvent(it)
        })

        events.addAll(substitution.away.map {
            DetailEvent(it).apply { isHome = false }
        })

        view.showEvents(events.apply {
            sortBy { it.time.toInt() }
        })
    }
}
