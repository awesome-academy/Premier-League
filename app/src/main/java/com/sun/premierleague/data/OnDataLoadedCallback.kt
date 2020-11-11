package com.sun.premierleague.data

import java.lang.Exception

interface OnDataLoadedCallback<T> {
    fun onSuccess(data: T)
    fun onFailure(exception: Exception = Exception("Unexpected Error"))
}
