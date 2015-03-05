package controllers.utils

import java.util.Calendar

object CalendarUtils {
  private val instance = Calendar.getInstance();
  
  val getYear : String = instance.get(Calendar.YEAR).toString()
  val getMonth : String = instance.get(Calendar.MONTH).toString()
  
  private val daysInMonth = instance.getActualMaximum(Calendar.DAY_OF_MONTH)
  private val dayOfWeekForBegOfMonth = {
    val tmpCalendar = Calendar.getInstance()
    tmpCalendar.set(Calendar.YEAR, Calendar.MONTH, 1)
    tmpCalendar.get(Calendar.DAY_OF_WEEK)
  }
  def getDays(rw : Int, cl : Int) : Int = {
    val res = rw*7 + cl + 2 - dayOfWeekForBegOfMonth;
    if((res < 0) || (res > daysInMonth)){
      0
    }else{
      res
    }
  }
  val getCurrentDay : Integer = instance.get(Calendar.DAY_OF_MONTH)
}