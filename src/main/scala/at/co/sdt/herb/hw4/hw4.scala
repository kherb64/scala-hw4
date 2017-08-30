package at.co.sdt.herb

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

  lazy val projectDir: JFile = new JFile("C:/IdeaProjects/scala-hw4/").getCanonicalFile
  lazy val resourcesDir: JFile = new JFile(projectDir + "/src/main/resources/").getCanonicalFile

}

