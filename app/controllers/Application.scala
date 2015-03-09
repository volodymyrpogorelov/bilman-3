package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index(calendarMonthOffset: Int) = Action {
    Ok(views.html.index(calendarMonthOffset))
  }
  
  def news(calendarMonthOffset: Int) = Action {
    Ok(views.html.news(calendarMonthOffset))
  }
  
  def schedule(calendarMonthOffset: Int) = Action {
    Ok(views.html.schedule(calendarMonthOffset))
  }
  
  def schedule_children(calendarMonthOffset: Int) = Action {
    Ok(views.html.schedule_children(calendarMonthOffset))
  }
  
  def photos(calendarMonthOffset: Int) = Action {
    Ok(views.html.photos(calendarMonthOffset))
  }
  
  def videos(calendarMonthOffset: Int) = Action {
    Ok(views.html.videos(calendarMonthOffset))
  }
  
  def contacts(calendarMonthOffset: Int) = Action {
    Ok(views.html.contacts(calendarMonthOffset))
  }
  
  def forum(calendarMonthOffset: Int) = Action {
    Ok(views.html.forum(calendarMonthOffset))
  }

}