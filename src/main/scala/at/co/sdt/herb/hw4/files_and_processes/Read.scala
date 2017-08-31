package at.co.sdt.herb.hw4.files_and_processes

import java.io.{ FileNotFoundException, IOException, File => JFile }

import scala.io.Source

import at.co.sdt.herb.hw4

object Read extends App {
  val whereami = System.getProperty("user.dir")
  println(s"whereami = $whereami")

  // new Read().readConcise("textfile.txt")
  // new Read().readProperly("textfile.txt")
  // new Read().readWithLoanPattern("textfile.txt")
  val contents = new Read().readTextFile("textfile.txt")
  println(contents)
  println(new Read().readTextFile("textfile.txt2"))
}

class Read {
  def resourcesFile(fileName: String): JFile = {
    new JFile(hw4.resourcesDir + "/" + fileName).getCanonicalFile
  }

  /**
    * Attention: leaves file open!
    */
  def readConcise(filename: String): Unit = {
    val file: JFile = resourcesFile(filename)

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

  def readProperly(filename: String): Unit = {
    println("reading properly")
    val bufferedSource = Source.fromFile(resourcesFile(filename))
    for (line <- bufferedSource.getLines) {
      println(line)
    }
    bufferedSource.close
    println("read properly")
  }

  /**
    * reads the file with the 'loan pattern'
    */
  def readWithLoanPattern(filename: String): Unit = {
    println("try reading")
    try {
      val bufferedSource = Source.fromFile(resourcesFile(filename))

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
      val lines = using(io.Source.fromFile(resourcesFile(filename))) { source =>
        (for (line <- source.getLines) yield line).toList
      }
      Some(lines)
    } catch {
      case e: Exception =>
        println(e)
        None
    }
  }
}

object Control {
  def using[A <: {def close() : Unit}, B](resource: A)(f: A => B): B =
    try {
      f(resource)
    } finally {
      import scala.language.reflectiveCalls
      resource.close()
    }
}