package models

/**
 * @author vladimir
 */

import scala.collection.generic.CanBuildFrom

class Date(year : Int, month : Int, day : Int, block : Block) {
  val getYear : Int = year
  val getMonth : Int = month
  val getDay : Int = day
  
  val fullDate : String = {
    val dStr = if(day > 9) s"$day"
               else        s"0$day"
    val mStr = if(month > 9) s"$month"
               else        s"0$month"
               
    s"$dStr-$mStr-$year"
  }
  
  def foreach[U](f : News => U) : Unit = {
    block.getNewsList.foreach(f) 
  }
  
  def map[B, That](f : News => B)(implicit bf: CanBuildFrom[List[News], B, That]) : That = {
    block.getNewsList.map[B, That] (f)
  }
  
  val getNumberOfNews : Int = block.getNewsList.size
}