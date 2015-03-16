package models

import scala.collection.mutable.ListBuffer
import scala.collection.generic.CanBuildFrom

object NewsBlock {
  val NEWS_PER_PAGE = 8
  val BLOCKS_PER_PAGE = 8 // Should be 5 or bigger
  
  def getChunkBeg(currentNewsBlock : Int) : Int = {
    val res = (currentNewsBlock + 1) / BLOCKS_PER_PAGE * BLOCKS_PER_PAGE
    if(res == 0) 1
    else res
  }
  
  def getChunkEnd(currentNewsBlock : Int, numberOfBlocks : Int) : Int = {
    val chunkBeg = getChunkBeg(currentNewsBlock)
    if ((chunkBeg + BLOCKS_PER_PAGE) >  numberOfBlocks) 
      numberOfBlocks 
    else 
      chunkBeg + BLOCKS_PER_PAGE - 1 
  }
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