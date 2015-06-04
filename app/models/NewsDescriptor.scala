package models

class NewsDescriptor(date : String, time : String, body : String) {
  def getDate = date
  def getBody = body
  def getTime = time
}