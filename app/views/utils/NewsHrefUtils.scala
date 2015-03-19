package views.utils

import models.NewsBlock

object NewsHrefUtils {
  def buildHref(calendarMonthOffset: Int, currentNewsBlock : Int) : String = {
    s"/news?monthOffset=$calendarMonthOffset&newsBlock=$currentNewsBlock"
  }
  
  def buildHrefForPrevChunk(calendarMonthOffset: Int, currentNewsBlock : Int) : String = {
     val prevEl = NewsBlock.getChunkBeg(currentNewsBlock) - 2
     if(prevEl > 1)
       buildHref(calendarMonthOffset, NewsBlock.getChunkBeg(prevEl))
     else
       buildHref(calendarMonthOffset, 1)
  }
  
  def buildHrefForNextChunk(calendarMonthOffset: Int, currentNewsBlock : Int, numberOfNewsBlocks : Int) : String = {
    buildHref(calendarMonthOffset, NewsBlock.getChunkEnd(currentNewsBlock, numberOfNewsBlocks) + 1)
  }
}