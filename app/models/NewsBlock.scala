package models

import scala.collection.mutable.ListBuffer

object NewsBlock {
  val NEWS_PER_PAGE = 8
  val BLOCKS_PER_PAGE = 4
}

class NewsBlock(page : Int, news : List[NewsDescriptor]) {
  val numberOfNews : Int = news.size
  
}