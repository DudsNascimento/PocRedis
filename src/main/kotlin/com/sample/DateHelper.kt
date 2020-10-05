package com.sample

import java.time.temporal.ChronoUnit
import java.util.Date
import java.util.Calendar;
import java.text.SimpleDateFormat
import java.text.ParseException
import java.time.LocalDate
import java.time.ZoneId

private fun getSimpleDateFormat(): SimpleDateFormat {
    return SimpleDateFormat("yyyy-MM-dd")
}

public fun dateToString(date: Date): String {
    return getSimpleDateFormat().format(date)
}

public fun stringToDate(date: String): Date? {

    try {
        return getSimpleDateFormat().parse(date)
    } catch (e: ParseException) {
        return null
    }
}

public fun getMonthsBetweenDates(date1: Date, date2: Date): Long {

    var localDate1 = date1.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
    var localDate2 = date2.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
 
    return ChronoUnit.MONTHS.between(
        localDate1,
        localDate2);
}

public fun addMonths(date: Date, months: Int): Date {

    val calendar: Calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.add(Calendar.MONTH, months)
    return calendar.getTime()
}