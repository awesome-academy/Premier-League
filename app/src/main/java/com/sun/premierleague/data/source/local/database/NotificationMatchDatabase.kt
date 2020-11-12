package com.sun.premierleague.data.source.local.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.sun.premierleague.data.model.NotificationMatch

class NotificationMatchDatabase(context: Context, dbName: String, version: Int) :
    SQLiteOpenHelper(context, dbName, null, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_FOOTBALL)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DROP_TABLE_TASK)
        onCreate(db)
    }

    companion object {
        private const val NAME_DB = "football.db"
        private const val VERSION = 1
        private const val CREATE_TABLE_FOOTBALL =
            "CREATE TABLE " + NotificationMatch.TABLE_NAME + " ( " +
                    NotificationMatch.MATCH_ID + " TEXT NOT NULL, " +
                    NotificationMatch.MATCH_DATE + " TEXT, " +
                    NotificationMatch.MATCH_TIME + " TEXT, " +
                    NotificationMatch.MATCH_HOME_TEAM_ID + " TEXT, " +
                    NotificationMatch.MATCH_HOME_TEAM_NAME + " TEXT, " +
                    NotificationMatch.MATCH_AWAY_TEAM_ID + " TEXT, " +
                    NotificationMatch.MATCH_AWAY_TEAM_NAME + " TEXT, " +
                    " PRIMARY KEY(" + NotificationMatch.MATCH_ID + "));"
        private const val DROP_TABLE_TASK =
            "DROP TABLE IF EXISTS " + NotificationMatch.TABLE_NAME
        private var instance: NotificationMatchDatabase? = null

        fun getInstance(context: Context): NotificationMatchDatabase =
            instance ?: synchronized(this) {
                instance ?: NotificationMatchDatabase(
                    context,
                    NAME_DB,
                    VERSION
                ).also { instance = it }
            }
    }
}
