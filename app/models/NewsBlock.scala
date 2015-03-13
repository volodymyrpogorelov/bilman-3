package models

import scala.collection.mutable.ListBuffer
import scala.collection.generic.CanBuildFrom

object NewsBlock {
  val NEWS_PER_PAGE = 8
  val BLOCKS_PER_PAGE = 4
}

class NewsBlock(page : Int, news : List[NewsDescriptor]) {
  val numberOfNews : Int = news.size
  
  def foreach[U](f : NewsDescriptor => U) : Unit = {
    news.foreach(f) 
  }
  
  def map[B, That](f : NewsDescriptor => B)(implicit bf: CanBuildFrom[List[NewsDescriptor], B, That]) : That = {
    news.map[B, That] (f)
  }
}