package models

/**
 * @author vladimir
 */

import scala.collection.generic.CanBuildFrom

class Page (dates : List[Date]){
  def foreach[U](f : Date => U) : Unit = {
    dates.foreach(f) 
  }
  
  def map[B, That](f : Date => B)(implicit bf: CanBuildFrom[List[Date], B, That]) : That = {
    dates.map[B, That] (f)
  }
}