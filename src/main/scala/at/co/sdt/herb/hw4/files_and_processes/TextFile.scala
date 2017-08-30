package at.co.sdt.herb.hw4.files_and_processes

import scala.io.BufferedSource

object TextFile extends App {

  import at.co.sdt.herb.hw4

  val srcFile = hw4.resourcesDir + "/textfile.txt?"
  val lineCount = new TextFile(srcFile).lineCount
  println(s"$srcFile has $lineCount lines")
  val lineCount2 = new TextFile(srcFile).lineCount2
  println(s"$srcFile has $lineCount2 lines")
  val lineCount3 = new TextFile(srcFile).lineCount3
  println(s"$srcFile has $lineCount3 lines")
}

class TextFile(fileName: String) {

  import java.io.{ File => JFile }

  // TODO: how to open files safely? with Option or so?
  val sourceFile: JFile = new JFile(fileName).getCanonicalFile
  val source: BufferedSource = io.Source.fromFile(sourceFile)

  // for {line <- source.getLines()} { println(line) }

  def lineCount: Long = {
    val NewLine = 10
    var newlineCount = 0L
    for {
      char <- source
      if char.toByte == NewLine
    } newlineCount += 1
    newlineCount + 1
  }

  def lineCount2: Long = {
    var newlineCount = 0L
    for {line <- source.getLines()} {
      newlineCount += 1
    }
    newlineCount
  }

  def lineCount3: Long = source.getLines().length
}