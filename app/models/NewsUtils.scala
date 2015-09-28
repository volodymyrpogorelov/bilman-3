package models

import scala.collection.mutable.ListBuffer
import java.util.GregorianCalendar
import java.text.SimpleDateFormat



object NewsUtils {
  private val allNews = {
    var res : List[NewsDescriptor] = List()
    val lines = 1 to 1
    
    val acc : StringBuilder = new StringBuilder("")
    var state = 0
    var data = ""
    var index = 0
    
    val date_s : String  = " 2011-01-18 00:00:00.0"; 
    val dt : SimpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
    val date = dt.parse(date_s); 
    lines.foreach { line => 
        res = (new NewsDescriptor(new GregorianCalendar(2013,10,28), "Привітання", "С новым 2015 годом!!!")) :: res 
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