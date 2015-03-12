package models


object NewsUtils {
  val getNews = {
    var res : List[NewsDescriptor] = List()
    val source = scala.io.Source.fromFile("/home/vladimir/workspace/bilman-3/app/models/news_db.txt")
    val lines = source.getLines()
    
    val acc : StringBuilder = new StringBuilder("")
    var state = 0
    var data = ""
    lines.foreach { line => 
      if(line.trim() == "BEG"){
        acc.clear()
        state = 1
      }else if(state == 1){
        data = line.trim()
        state = 0
      }else if (line.trim() == "END"){
        res = (new NewsDescriptor("2015-01-01", "С новым 2015 годом!!!")) :: res 
      }
    }
    source.close()
    res
  }
}