package controllers.utils

class CalendarDay(day : Int, today : Boolean, dayOfCurrentMonth : Boolean) {
  def getDay = day
  def isTodaysDay = today
  def isDayOfCurrentMonth = dayOfCurrentMonth
}