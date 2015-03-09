package controllers.utils

import java.util.Calendar

class CalendarUtils(currentMonthOffestNotNormalized : Int) {
  private val MAX_MONTH_OFFSET = 240
  
  private val currentMonthOffest : Int = if (currentMonthOffestNotNormalized > MAX_MONTH_OFFSET) MAX_MONTH_OFFSET
                                         else if (currentMonthOffestNotNormalized < -MAX_MONTH_OFFSET) -MAX_MONTH_OFFSET
                                              else currentMonthOffestNotNormalized
  private val today = Calendar.getInstance
  private val shiftedMonth = today.get(Calendar.MONTH) + currentMonthOffest
  private val currentMonth : Int = if(shiftedMonth >= 0) shiftedMonth % 12
                                   else 12 + shiftedMonth % 12
  private val currentYear = {
    val currentYearOffset : Int =  
      if(shiftedMonth >= 0) shiftedMonth / 12
      else (shiftedMonth - 11) / 12
    today.get(Calendar.YEAR) + currentYearOffset 
  } 
  
  private val currentCalendar = {
    val tmp = Calendar.getInstance()
    tmp.set(currentYear, currentMonth, tmp.get(Calendar.DAY_OF_MONTH))
    tmp
  }
  private val months = Map(
                        Calendar.JANUARY -> "Январь",
                        Calendar.FEBRUARY -> "Февраль",
                        Calendar.MARCH -> "Март",
                        Calendar.APRIL -> "Апрель",
                        Calendar.MAY -> "Май",
                        Calendar.JUNE -> "Июнь",
                        Calendar.JULY -> "Июль",
                        Calendar.AUGUST -> "Август",
                        Calendar.SEPTEMBER -> "Сентябрь",
                        Calendar.OCTOBER -> "Октябрь",
                        Calendar.NOVEMBER -> "Ноябрь",
                        Calendar.DECEMBER -> "Декабрь")
                        
  private val weekDaysBckw = Map(
                        Calendar.MONDAY -> 0,
                        Calendar.TUESDAY -> 1,
                        Calendar.WEDNESDAY -> 2,
                        Calendar.THURSDAY -> 3,
                        Calendar.FRIDAY -> 4,
                        Calendar.SATURDAY -> 5,
                        Calendar.SUNDAY -> 6)
  
  val getYear : String = currentCalendar.get(Calendar.YEAR).toString()
  val getMonth : String = months.get(currentCalendar.get(Calendar.MONTH)) match {
    case Some (res) => res
    case None => ""
  }
  
  private val daysInPrevMonth = {
    val prevMonth = currentCalendar.get(Calendar.MONTH) - 1;
    if(prevMonth < 0){
      31
    }else {
      val tmp = Calendar.getInstance()
      tmp.set(currentCalendar.get(Calendar.YEAR), prevMonth, 1)
      tmp.getActualMaximum(Calendar.DAY_OF_MONTH)
    }
  }
  private val daysInMonth = currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)
  private val dayOfWeekForBegOfMonth = {
    val tmpCalendar = Calendar.getInstance()
    tmpCalendar.set(currentCalendar.get(Calendar.YEAR), currentCalendar.get(Calendar.MONTH), 1)
    weekDaysBckw.get(tmpCalendar.get(Calendar.DAY_OF_WEEK)) match {
      case Some (res) => res
      case None => 0
    }
  }
  def getDays(rw : Int, cl : Int) : CalendarDay = {
    val res = rw*7 + cl + 1 - dayOfWeekForBegOfMonth;
    if(res <= 0){
      new CalendarDay(daysInPrevMonth + res, false, false)
    }else { 
      if(res > daysInMonth) new CalendarDay(res - daysInMonth, false, false)
      else new CalendarDay(res, res == getCurrentDay && 
                                currentYear == today.get(Calendar.YEAR) && 
                                currentMonth == today.get(Calendar.MONTH), true)
    }
  }
  val getCurrentDay : Integer = currentCalendar.get(Calendar.DAY_OF_MONTH)
}