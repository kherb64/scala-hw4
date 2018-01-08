package at.co.sdt.herb.hw4.files_and_processes

import java.io.{File => JFile}

import scala.sys.process._

/**
  * Works with large xml files on server
  */
class LargeXml(path: String) {

  def findLargest: String = {
    // "bash -c pwd".!!

    val bangResult = Seq("find", path, "-name", "*.xml").!!
    // bangResult foreach (f => println(f))
    println(s"${bangResult.length} characters recevied")
    val fileNames = bangResult.split("\n").toList
    println(s"${fileNames.length} filenames recevied")

    val files = for (fileName <- fileNames)
      yield {
        new JFile(fileName).getCanonicalFile
      }
    /* files foreach println
    println(s"$files filesizes calculated") */

    val sortedFiles = files.sortWith(_.length > _.length)
    // sortedFiles foreach (f => println(s" ${f.length} Bytes $f"))

    val largestFile = files.sortWith(_.length > _.length).head
    println(s"${largestFile.length()} Bytes largest file ${largestFile.getCanonicalPath}")

    /* current directory only
    val file: JFile = new JFile(path).getCanonicalFile
    val fileNames = file.listFiles()
    println(fileNames) */

    "bertl.xml"
  }
}

object LargeXmlDemo extends App {
  val largest = new LargeXml("/media/herb/sdt/sdt08/apps/material/r+d").findLargest
  // val largestFut = new LargeXml("/apps").findLargest
  // largestFut.onComplete()
}