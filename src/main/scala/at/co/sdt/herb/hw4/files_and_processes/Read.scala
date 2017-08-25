package at.co.sdt.herb.hw4.files_and_processes

import java.io.{ File => JFile }

import at.co.sdt.herb.hw4

import scala.io.Source

object Read extends App {
  new Read().readConcise()
  new Read().readProperly()
}

class Read {
  def resFile(fileName: String): JFile = {
    new JFile(hw4.resDir + "/" + fileName).getCanonicalFile
  }

  def readConcise(): Unit = {
    val file:JFile = resFile("textfile.txt")

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
    println("reading porperly")
    val bufferedSource = Source.fromFile(resFile("textfile.txt"))
    for (line <- bufferedSource.getLines) {
      println(line)
    }
    bufferedSource.close
    println("read porperly")
  }
}
