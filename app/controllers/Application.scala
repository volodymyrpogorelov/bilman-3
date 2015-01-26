package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def news = Action {
    Ok(views.html.news("Your new application is ready."))
  }
  
  def schedule = Action {
    Ok(views.html.schedule("Your new application is ready."))
  }
  
  def photos = Action {
    Ok(views.html.photos("Your new application is ready."))
  }
  
  def videos = Action {
    Ok(views.html.videos("Your new application is ready."))
  }
  
  def contacts = Action {
    Ok(views.html.contacts("Your new application is ready."))
  }
  
  def forum = Action {
    Ok(views.html.forum("Your new application is ready."))
  }

}