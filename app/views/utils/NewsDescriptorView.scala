package views.utils

import models.NewsDescriptor

class NewsDescriptorView(date : String, time : String, body : String, showDate : Boolean) extends NewsDescriptor(date, time, body) {
  def shouldShowDate = showDate
}