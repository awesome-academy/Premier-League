package com.sun.premierleague.ui.match

import com.sun.premierleague.data.model.MatchItem
import com.sun.premierleague.data.model.Time
import com.sun.premierleague.data.source.FootballRepository
import com.sun.premierleague.data.source.remote.OnDataLoadedCallback
import com.sun.premierleague.utils.TimeUtils
import java.lang.Exception

class MatchPresenter(
    private val view: MatchContract.View,
    private val repository: FootballRepository
) : MatchContract.Presenter {

    private var time: Time? = null

    override fun start() {
        time = TimeUtils.getTime(DISTANCE_FROM, DISTANCE_TO)
        time?.let { getMatchInformation(it) }
    }

    override fun getMatchInformation(time: Time) {
        repository.getMatch(time, object : OnDataLoadedCallback<List<MatchItem>> {
            override fun onSuccess(data: List<MatchItem>) {
                view.showMatch(data)
            }

            override fun onFailure(exception: Exception?) {
                view.showError(exception?.message.toString())
            }
        })
    }

    companion object {
        private const val DISTANCE_FROM = 10
        private const val DISTANCE_TO = 10
    }
}
