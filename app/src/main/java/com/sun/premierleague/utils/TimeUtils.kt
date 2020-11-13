package com.sun.premierleague.utils

import com.sun.premierleague.base.BaseView
import com.sun.premierleague.data.model.Time
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

object TimeUtils : BaseView {

    private const val ONE = 1
    private const val MONTH_IN_YEAR = 12
    private const val FORMAT_DATE_TO_GET = "yyyy-MM-dd"

    fun getTime(distanceFrom: Int, distanceTo: Int): Time? {
        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = ((currentDate.get(Calendar.MONTH) + ONE) % MONTH_IN_YEAR)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)

        val dayFrom = day - distanceFrom
        val dayTo = day + distanceTo

        val fakeDateFrom = "$year-$month-$dayFrom"
        val fakeDateTo = "$year-$month-$dayTo"

        try {
            val dateFrom =
                SimpleDateFormat(FORMAT_DATE_TO_GET, Locale.getDefault()).parse(fakeDateFrom)
            val dateTo = SimpleDateFormat(FORMAT_DATE_TO_GET, Locale.getDefault()).parse(fakeDateTo)
            val from = SimpleDateFormat(FORMAT_DATE_TO_GET, Locale.getDefault()).format(dateFrom)
            val to = SimpleDateFormat(FORMAT_DATE_TO_GET, Locale.getDefault()).format(dateTo)
            return Time(from, to)
        } catch (e: Exception) {
            showMessage(e.toString())
        }
        return null
    }
}
