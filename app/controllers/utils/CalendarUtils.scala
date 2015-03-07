package controllers.utils

import java.util.Calendar

object CalendarUtils {
  private val instance = Calendar.getInstance();
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
  
  val getYear : String = instance.get(Calendar.YEAR).toString()
  val getMonth : String = months.get(instance.get(Calendar.MONTH)) match {
    case Some (res) => res
    case None => ""
  }
  
  private val daysInMonth = instance.getActualMaximum(Calendar.DAY_OF_MONTH)
  private val dayOfWeekForBegOfMonth = {
    val tmpCalendar = Calendar.getInstance()
    tmpCalendar.set(instance.get(Calendar.YEAR), instance.get(Calendar.MONTH), 1)
    weekDaysBckw.get(tmpCalendar.get(Calendar.DAY_OF_WEEK)) match {
      case Some (res) => res
      case None => 0
    }
  }
  def getDays(rw : Int, cl : Int) : CalendarDay = {
    val res = rw*7 + cl + 1 - dayOfWeekForBegOfMonth;
    if(res < 0){
      new CalendarDay(0, false, false)
    }else { 
      if(res > daysInMonth) new CalendarDay(res - daysInMonth, false, false)
      else new CalendarDay(res, res == getCurrentDay, true)
    }
  }
  val getCurrentDay : Integer = instance.get(Calendar.DAY_OF_MONTH)
}