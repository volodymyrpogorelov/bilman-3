package views.utils

object NewsHrefUtils {
  def buildHref(calendarMonthOffset: Int, currentNewsBlock : Int) : String = {
    s"/news?monthOffset=$calendarMonthOffset&newsBlock=$currentNewsBlock"
  }
  
  def buildHrefForBackBlock(calendarMonthOffset: Int, currentNewsBlock : Int) : String = {
    if(currentNewsBlock == 0){
       "#"
    }else {
      buildHref(calendarMonthOffset, currentNewsBlock - 1)
    }
  }
  
  def buildHrefForNextBlock(calendarMonthOffset: Int, currentNewsBlock : Int, numberOfNewsBlocks : Int) : String = {
    if(currentNewsBlock == numberOfNewsBlocks - 1){
      "#"
    }else {
      buildHref(calendarMonthOffset, currentNewsBlock + 1)
    }
  }
}