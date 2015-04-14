package controllers.utils

/**
 * @author pogorelov
 */

import java.io.File

object PhotoGalleryUtils {
  
  private def getListOfFiles(dir: String) : List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }
  
  val allPhotosPath = getListOfFiles("./public/photos/gallery/")
  val currentPath = new java.io.File( "." ).getCanonicalPath
  
}