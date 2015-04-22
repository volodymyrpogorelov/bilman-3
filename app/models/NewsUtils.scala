package models

import scala.collection.mutable.ListBuffer


object NewsUtils {
  private val allNews = {
    var res : List[NewsDescriptor] = List()
    val lines = 1 to 1
    
    val acc : StringBuilder = new StringBuilder("")
    var state = 0
    var data = ""
    var index = 0
    lines.foreach { line => 
        res = (new NewsDescriptor(s"$index) 2015-01-01", "С новым 2015 годом!!!")) :: res 
        index += 1
    }
    res.reverse
  }
  
  private val newsBlocks = {
    val tmp = allNews.grouped(NewsBlock.NEWS_PER_PAGE).toList
    (for((x, i) <- tmp.zipWithIndex) yield new NewsBlock(i, x))
  }
  val numberOfBlocks : Int = newsBlocks.size 
  
  def nthNews(i : Int) : NewsBlock = {
    newsBlocks(i - 1)
  }
}