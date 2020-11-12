package com.sun.premierleague.data.source.local.dao

import com.sun.premierleague.data.model.NotificationMatch
import com.sun.premierleague.data.source.local.database.NotificationMatchDatabase

class NotificationMatchDAOImpl(notificationMatchDatabase: NotificationMatchDatabase) :
    NotificationMatchDAO {

    private val writableDatabase = notificationMatchDatabase.writableDatabase
    private val readableDatabase = notificationMatchDatabase.readableDatabase

    override fun getFootballNotifications(): List<NotificationMatch> {
        val listNotificationMatches = mutableListOf<NotificationMatch>()
        val mCursor =
            readableDatabase.query(NotificationMatch.TABLE_NAME, null, null, null, null, null, null)
        mCursor.moveToFirst()
        while (!mCursor.isAfterLast) {
            val matchID = mCursor.getString(mCursor.getColumnIndex(NotificationMatch.MATCH_ID))
            val matchDate = mCursor.getString(mCursor.getColumnIndex(NotificationMatch.MATCH_DATE))
            val matchTime = mCursor.getString(mCursor.getColumnIndex(NotificationMatch.MATCH_TIME))
            val matchHomeID =
                mCursor.getString(mCursor.getColumnIndex(NotificationMatch.MATCH_HOME_TEAM_ID))
            val matchHomeName =
                mCursor.getString(mCursor.getColumnIndex(NotificationMatch.MATCH_HOME_TEAM_NAME))
            val matchAwayID =
                mCursor.getString(mCursor.getColumnIndex(NotificationMatch.MATCH_AWAY_TEAM_ID))
            val matchAwayName =
                mCursor.getString(mCursor.getColumnIndex(NotificationMatch.MATCH_AWAY_TEAM_NAME))
            listNotificationMatches.add(
                NotificationMatch(
                    matchID,
                    matchDate,
                    matchTime,
                    matchHomeID,
                    matchHomeName,
                    matchAwayID,
                    matchAwayName
                )
            )
            mCursor.moveToNext()
        }
        mCursor.close()
        return listNotificationMatches
    }

    override fun getItemFootballNotification(idMatch: String): NotificationMatch {
        val mCursor = readableDatabase.query(
            false, NotificationMatch.TABLE_NAME, null, NotificationMatch.MATCH_ID + "= ?",
            arrayOf(idMatch), null, null, null, null
        )
        val matchID = mCursor.getString(mCursor.getColumnIndex(NotificationMatch.MATCH_ID))
        val matchDate = mCursor.getString(mCursor.getColumnIndex(NotificationMatch.MATCH_DATE))
        val matchTime = mCursor.getString(mCursor.getColumnIndex(NotificationMatch.MATCH_TIME))
        val matchHomeID =
            mCursor.getString(mCursor.getColumnIndex(NotificationMatch.MATCH_HOME_TEAM_ID))
        val matchHomeName =
            mCursor.getString(mCursor.getColumnIndex(NotificationMatch.MATCH_HOME_TEAM_NAME))
        val matchAwayID =
            mCursor.getString(mCursor.getColumnIndex(NotificationMatch.MATCH_AWAY_TEAM_ID))
        val matchAwayName =
            mCursor.getString(mCursor.getColumnIndex(NotificationMatch.MATCH_AWAY_TEAM_NAME))
        return NotificationMatch(
            matchID,
            matchDate,
            matchTime,
            matchHomeID,
            matchHomeName,
            matchAwayID,
            matchAwayName
        )
    }

    override fun addFootballNotification(notificationMatch: NotificationMatch): Boolean {
        val result = writableDatabase.insert(
            NotificationMatch.TABLE_NAME,
            null,
            notificationMatch.getContentValues()
        )
        return result > 0
    }

    override fun deleteFootballNotification(idMatch: String): Boolean {
        return writableDatabase.delete(
            NotificationMatch.TABLE_NAME,
            NotificationMatch.MATCH_ID + "= ?",
            arrayOf(idMatch)
        ) > 0
    }

    companion object {
        private var instance: NotificationMatchDAOImpl? = null

        fun getInstance(notificationMatchDatabase: NotificationMatchDatabase):
                NotificationMatchDAOImpl =
            instance ?: synchronized(this) {
                instance ?: NotificationMatchDAOImpl(notificationMatchDatabase).also {
                    instance = it
                }
            }
    }
}
