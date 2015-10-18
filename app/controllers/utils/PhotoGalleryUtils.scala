package controllers.utils

/**
 * @author pogorelov
 */

object PhotoGalleryUtils {
  
  private val getListOfFiles : List[String] = List[String](
    "38_UTSyCQuw.jpg",
    "45cGXJqP5Lo.jpg",
    "4nJHVXcTfCk.jpg",
    "JMSgYM6g5u8.jpg",
    "jwkqOanMtGA.jpg",
    "Q5C1CkI4rxk.jpg",
    "qDtjYCCJ4vk.jpg",
    "rSiEnmKzEHU.jpg",
    "s373rZ4OGQ8.jpg",
    "TLtnEptcxz0.jpg"
  )
    
  
  
  val allPhotosPath = getListOfFiles.map(f => "assets/photos/gallery/" + f)
  
}