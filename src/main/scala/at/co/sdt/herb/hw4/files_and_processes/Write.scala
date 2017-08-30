package at.co.sdt.herb.hw4.files_and_processes

import java.io.{ BufferedWriter, FileWriter }


object Write extends App {

  val whereami = System.getProperty("user.dir")
  println(s"whereami = $whereami")

  import at.co.sdt.herb.hw4

  new Write(hw4.resourcesDir + "/hello.txt").printWriter("Hello, world")
  new Write(hw4.resourcesDir + "/hello.txt?").printWriter("Illegal filename!")
  new Write(hw4.resourcesDir + "/hello2.txt").fileWriter("Hello, world!")
}

/**
  * calls various methods for writing a file
  *
  * @param fileName Name of the file to be written.
  */
class Write(fileName: String) {

  import java.io.{ IOException, File => JFile }

  /**
    * Uses PrintWriter
    *
    * @param text Content to be written
    */
  def printWriter(text: String): Unit = {

    // open file
    try {
      val file: JFile = new JFile(fileName).getCanonicalFile
      println(file)

      // write file
      import java.io.PrintWriter
      val pw = new PrintWriter(file)
      pw.write(text)
      pw.close()
    } catch {
      case e: IOException => println(e)
    }

  }

  /**
    * Uses FileWriter
    *
    * @param text Content to be written
    */
  def fileWriter(text: String): Unit = {

    // open file
    try {
      val file = new JFile(fileName).getCanonicalFile
      println(file)

      val bw = new BufferedWriter(new FileWriter(file))
      bw.write(text)
      bw.close()
    } catch {
      case e: IOException => println(e)
    }
  }


}
