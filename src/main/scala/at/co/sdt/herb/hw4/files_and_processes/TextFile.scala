package at.co.sdt.herb.hw4.files_and_processes

import java.io.{ File => JFile }

import scala.io.BufferedSource
import scala.util.{ Failure, Success, Try }

object TextFileDemo extends App {

  import at.co.sdt.herb.hw4

  val fileName = hw4.resourcesDir + "/textfile.txt?"
  val textFileOpt = TextFile.ofName(fileName)
  textFileOpt match {
    case Some(tf) => println(s"$fileName has ${ tf.lineCount } ${ tf.lineCount2 } ${ tf.lineCount3 } lines")
    case None => println(s"File $fileName not found")
  }

}

object TextFile {
  def apply(file: JFile): TextFile = {
    new TextFile(file)
  }

  def ofName(fileName: String): Option[TextFile] = {
    // open file by name safely with Try
    val sourceFile: Try[JFile] = Try(new JFile(fileName).getCanonicalFile)
    sourceFile match {
      case Success(tf) => Some(new TextFile(tf))
      case Failure(ex) =>
        println(ex)
        // ex.printStackTrace()
        None
    }
  }
}

class TextFile(file: JFile) {

  def source: BufferedSource = io.Source.fromFile(file)

  // for {line <- source.getLines()} { println(line) }

  def lineCount: Long = {
    val NewLine = '\n'
    var newlineCount = 0L
    for {
      char <- source
      if char.toByte == NewLine
    } newlineCount += 1
    source.close()
    newlineCount + 1
  }

  def lineCount2: Long = {
    var newlineCount = 0L
    for {_ <- source.getLines()} {
      newlineCount += 1
    }
    source.close()
    newlineCount
  }

  def lineCount3: Long = {
    val newlineCount = source.getLines().size
    source.close()
    newlineCount
  }
}
