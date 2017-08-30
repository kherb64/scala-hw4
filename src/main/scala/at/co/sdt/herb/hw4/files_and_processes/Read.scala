package at.co.sdt.herb.hw4.files_and_processes

import java.io.{ FileNotFoundException, IOException, File => JFile }

import at.co.sdt.herb.hw4

import scala.io.Source

object Read extends App {
  // new Read().readConcise()
  //new Read().readProperly()
  new Read().readWithLoanPattern()
}

class Read {
  def resourcesFile(fileName: String): JFile = {
    new JFile(hw4.resourcesDir + "/" + fileName).getCanonicalFile
  }

  /**
    * Attention: leaves file open!
    */
  def readConcise(): Unit = {
    val file: JFile = resourcesFile("textfile.txt")

    println("reading in a concise way")
    for (line <- Source.fromFile(file).getLines) {
      println(line)
    }
    println("read in a concise way")

    /*
    val lines = Source.fromFile("/Users/Al/.bash_profile").getLines.toList
    val lines = Source.fromFile("/Users/Al/.bash_profile").getLines.toArray

    val fileContents = Source.fromFile(filename).getLines.mkString
    */
  }

  def readProperly(): Unit = {
    println("reading properly")
    val bufferedSource = Source.fromFile(resourcesFile("textfile.txt"))
    for (line <- bufferedSource.getLines) {
      println(line)
    }
    bufferedSource.close
    println("read properly")
  }

  /**
    * reads the file with the 'loan pattern'
    */
  def readWithLoanPattern(): Unit = {
    println("try reading")
    try {
      val bufferedSource = Source.fromFile(resourcesFile("textfile.txt"))

      try {
        for (line <- bufferedSource.getLines()) {
          println(line)
        }
      } catch {
        case e: IOException => println(e)
      } finally {
        bufferedSource.close
      }

      println("read successful")
    } catch {
      case e: FileNotFoundException => println(e)
    }
  }

  def readTextFile(filename: String): Option[List[String]] = {
    import Control._
    try {
      val lines = using(io.Source.fromFile(filename)) { source =>
        (for (line <- source.getLines) yield line).toList
      }
      Some(lines)
    } catch {
      case _: Exception => None
    }
  }
}

object Control {
  def using[A <: { def close(): Unit }, B](resource: A)(f: A => B): B =
    try {
      f(resource)
    } finally {
      import scala.language.reflectiveCalls
      resource.close()
    }
}