package com.sun.premierleague.data.source.local

import android.os.AsyncTask
import com.sun.premierleague.data.source.remote.OnDataLoadedCallback

class LocalAsyncTask<P, T>(
    private val callback: OnDataLoadedCallback<T>,
    private val handler: (P) -> T
) : AsyncTask<P, Unit, T?>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg params: P): T? {
        try {
            handler(params.firstOrNull() ?: throw IllegalArgumentException("Param cannot be empty"))
        } catch (e: Exception) {
            exception = e
        }
        return null
    }

    override fun onPostExecute(result: T?) {
        result?.let(callback::onSuccess) ?: exception?.let(callback::onFailure)
    }
}
