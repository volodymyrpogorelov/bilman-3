package views.utils


class CalendarInfo(ref : String, monthOffset : Int) {
  val getRefBackward = ref + "?monthOffset=" + (if(monthOffset == Int.MinValue) monthOffset else (monthOffset - 1))
  val getRefForward = ref + "?monthOffset=" + (if(monthOffset == Int.MaxValue) monthOffset else (monthOffset + 1))
  val getMonthOffset = monthOffset
} 