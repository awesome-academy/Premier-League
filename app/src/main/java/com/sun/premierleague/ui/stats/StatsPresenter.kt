package com.sun.premierleague.ui.stats

import com.sun.premierleague.data.model.StatItem
import com.sun.premierleague.data.source.FootballRepository
import com.sun.premierleague.data.source.remote.OnDataLoadedCallback
import java.lang.Exception

class StatsPresenter(
    private val view: StatsContact.View,
    private val repository: FootballRepository
) : StatsContact.Presenter {

    override fun start() {
        getStatsInformation()
    }

    override fun getStatsInformation() {
        repository.getStat(object : OnDataLoadedCallback<List<StatItem>> {
            override fun onSuccess(data: List<StatItem>) {
                view.showStats(data)
            }

            override fun onFailure(exception: Exception?) {
                exception?.let {
                    view.showError(it.message.toString())
                }
            }
        })
    }
}
