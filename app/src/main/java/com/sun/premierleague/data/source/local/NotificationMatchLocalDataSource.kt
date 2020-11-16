package com.sun.premierleague.data.source.local

import com.sun.premierleague.data.model.MatchNotification
import com.sun.premierleague.data.source.FootballDataSource
import com.sun.premierleague.data.source.local.dao.NotificationMatchDAO

class NotificationMatchLocalDataSource(private val notificationMatchDAO: NotificationMatchDAO) :
    FootballDataSource.Local {
    override fun getFootballNotifications(): List<MatchNotification> =
        notificationMatchDAO.getFootballNotifications()

    override fun getItemFootballNotification(idMatch: String): MatchNotification =
        notificationMatchDAO.getItemFootballNotification(idMatch)

    override fun addFootballNotification(matchNotification: MatchNotification): Boolean =
        notificationMatchDAO.addFootballNotification(matchNotification)

    override fun deleteFootballNotification(idMatch: String): Boolean =
        notificationMatchDAO.deleteFootballNotification(idMatch)

    companion object {
        private var instance: NotificationMatchLocalDataSource? = null

        fun getInstance(notificationMatchDAO: NotificationMatchDAO): NotificationMatchLocalDataSource =
            instance ?: synchronized(this) {
                instance ?: NotificationMatchLocalDataSource(notificationMatchDAO).also {
                    instance = it
                }
            }
    }
}
