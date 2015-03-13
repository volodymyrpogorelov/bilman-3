package models

import scala.collection.mutable.ListBuffer


object NewsUtils {
  private val allNews = {
    var res : List[NewsDescriptor] = List()
    //val source = scala.io.Source.fromFile("/home/vladimir/workspace/bilman-3/app/models/news_db.txt")
    val source = scala.io.Source.fromFile("/home/pogorelov/Tmp/tmp/workspace/bilman-3/app/models/news_db.txt")
    val lines = source.getLines()
    
    val acc : StringBuilder = new StringBuilder("")
    var state = 0
    var data = ""
    var index = 0
    lines.foreach { line => 
      if(line.trim() == "BEG"){
        acc.clear()
        state = 1
      }else if(state == 1){
        data = line.trim()
        state = 0
      }else if (line.trim() == "END"){
        res = (new NewsDescriptor(s"$index) 2015-01-01", "С новым 2015 годом!!!")) :: res 
        index += 1
      }
    }
    source.close()
    res.reverse
  }
  
  private val newsBlocks = {
    val tmp = allNews.grouped(NewsBlock.NEWS_PER_PAGE).toList
    (for((x, i) <- tmp.zipWithIndex) yield new NewsBlock(i, x))
  }
  val numberOfBlocks : Int = newsBlocks.size 
  
  def nthNews(i : Int) : NewsBlock = {
    newsBlocks(i)
  }
}