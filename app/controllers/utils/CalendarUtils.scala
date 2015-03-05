package controllers.utils

import java.util.Calendar

object CalendarUtils {
  private val instance = Calendar.getInstance();
  private val months = Map(0 -> "Январь",
                        1 -> "Февраль",
                        2 -> "Март",
                        3 -> "Апрель",
                        4 -> "Май",
                        5 -> "Июнь",
                        6 -> "Июль",
                        7 -> "Август",
                        8 -> "Сентябрь",
                        9 -> "Октябрь",
                        10 -> "Ноябрь",
                        11 -> "Декабрь")
  
  val getYear : String = instance.get(Calendar.YEAR).toString()
  val getMonth : String = months.get(instance.get(Calendar.MONTH)) match {
    case Some (res) => res
    case None => ""
  }
  
  private val daysInMonth = instance.getActualMaximum(Calendar.DAY_OF_MONTH)
  private val dayOfWeekForBegOfMonth = {
    val tmpCalendar = Calendar.getInstance()
    tmpCalendar.set(instance.get(Calendar.YEAR), instance.get(Calendar.MONTH) - 1, 1)
    val tmp = tmpCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)
    tmp
  }
  def getDays(rw : Int, cl : Int) : Int = {
    val res = rw*7 + cl + 1 - dayOfWeekForBegOfMonth;
    if((res < 0) || (res > daysInMonth)){
      0
    }else{
      res
    }
  }
  val getCurrentDay : Integer = instance.get(Calendar.DAY_OF_MONTH)
}