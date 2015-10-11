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
  
  private val allNewsPages : List[Page] = {
    val filePath = "https://raw.githubusercontent.com/volodymyrpogorelov/bilman-3/master/public/news_db.xml"
    val rootElem = XML.load(filePath)
   (rootElem \\ "page").map { p =>  {
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
               new Date(year, month, day, block)
             }}.toList
           new Page(dates)
       }}.toList
  }
  
  val numberOfPages : Int = allNewsPages.size
  
  def nthPage(i : Int) : Page = {
    allNewsPages(i - 1)
  }
}