package com.sun.premierleague.data.source.local.dao

import com.sun.premierleague.data.model.NotificationMatch

interface NotificationMatchDAO {
    fun getFootballNotifications(): List<NotificationMatch>
    fun getItemFootballNotification(idMatch: String): NotificationMatch
    fun addFootballNotification(notificationMatch: NotificationMatch): Boolean
    fun deleteFootballNotification(idMatch: String): Boolean
}
