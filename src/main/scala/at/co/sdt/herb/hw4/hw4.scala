package at.co.sdt.herb

import scala.util.{ Failure, Success, Try }

/**
  * my first package object
  */
package object hw4 {
  hw4IsHere()

  /**
    * print package object's name
    */
  def hw4IsHere(): Unit = {
    println(s"$toString is here")
  }

  override def toString: String = s"package object ${ this.getClass }"

  import java.io.{ File => JFile }

  private lazy val userDir = System.getProperty("user.dir")
  lazy val projectDir: JFile = new JFile(userDir + "/").getCanonicalFile
  lazy val resourcesDir: JFile = new JFile(projectDir + "/src/main/resources/").getCanonicalFile

  trait File {
    def ofName(fileName: String): Option[JFile] = {
      // open file by name safely with Try
      val file: Try[JFile] = Try(new JFile(fileName).getCanonicalFile)
      file match {
        case Success(f) => Some(f)
        case Failure(ex) =>
          println(ex)
          // ex.printStackTrace()
          None
      }
    }
  }

  object File extends File {
  }

}
