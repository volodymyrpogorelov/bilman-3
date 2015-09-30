package models

import scala.collection.mutable.ListBuffer
import java.util.GregorianCalendar
import java.text.SimpleDateFormat
import scala.xml.XML
import scala.xml.Node
import scala.xml.NodeSeq



object NewsUtils {
  private def extractPrimValFromTag(n : Node, tagName : String) : String = {
    val ns = (n \ tagName)
    val node = ns(0)
    val childs = node.child
    val child = childs(0)
    val res = child.text
    res.trim()
  }
  
  private val allNews = {
    var res : List[NewsDescriptor] = List()
    val lines = 1 to 1
    val rootElem = XML.loadFile("/home/vladimir/workspace/bilman-3/app/models/news_db.xml")
    val pages : List[Page] =  (rootElem \\ "page").map { p =>  {
           val dates : List[Date] = (p \ "date").map { x => {
               val year = extractPrimValFromTag(x, "year").toInt
               val month : Int = extractPrimValFromTag(x, "month").toInt
               val day : Int = extractPrimValFromTag(x, "day").toInt
               val block = (x \ "block").map {x => {
                 val newsList : List[News] = (x \ "news").map{x => {
                   val time : String = extractPrimValFromTag(x, "time")
                   val caption : String = extractPrimValFromTag(x, "caption")
                   val body : String = extractPrimValFromTag(x, "body")
                   new News(time, caption, body)
                 }}.toList
                 new Block(newsList)
               }}.head 
               new Date(1, month, day, block)
             }}.toList
           new Page(dates)
       }}.toList
    
    val acc : StringBuilder = new StringBuilder("")
    var state = 0
    var data = ""
    var index = 0
    
    val date_s : String  = " 2011-01-18 00:00:00.0"; 
    val dt : SimpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
    val date = dt.parse(date_s); 
    lines.foreach { line => 
        res = (new NewsDescriptor(new GregorianCalendar(2013,10,28), "Привітання", "")) :: res 
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