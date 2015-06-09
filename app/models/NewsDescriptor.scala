package models

import java.util.Calendar


class NewsDescriptor(datetime : Calendar, caption : String, body : String) {
  val getYear = datetime.get(Calendar.YEAR)
  val getMonth = datetime.get(Calendar.MONTH)
  val getDay = datetime.get(Calendar.DAY_OF_MONTH)
  val getTime = datetime.getTime
  val getCaption = caption
  val getBody = body
}