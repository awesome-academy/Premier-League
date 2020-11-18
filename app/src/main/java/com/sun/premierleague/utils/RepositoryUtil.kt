package com.sun.premierleague.utils

import android.content.Context
import com.sun.premierleague.data.source.FootballRepository
import com.sun.premierleague.data.source.local.NotificationMatchLocalDataSource
import com.sun.premierleague.data.source.local.dao.NotificationMatchDAOImpl
import com.sun.premierleague.data.source.local.database.AppDatabase
import com.sun.premierleague.data.source.remote.RemoteDataSource

object RepositoryUtil {
    fun getRepository(context: Context): FootballRepository {
        val appDatabase = AppDatabase.getInstance(context)
        val notificationMatchDAOImpl = NotificationMatchDAOImpl.getInstance(appDatabase)
        val local = NotificationMatchLocalDataSource.getInstance(notificationMatchDAOImpl)
        val remote = RemoteDataSource()
        return FootballRepository.getInstance(local, remote)
    }
}
