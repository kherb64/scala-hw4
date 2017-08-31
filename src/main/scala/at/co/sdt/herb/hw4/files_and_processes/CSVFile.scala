package at.co.sdt.herb.hw4.files_and_processes

import java.io.{ File => JFile }

import at.co.sdt.herb.hw4

object CSVFileDemo extends App {

  import at.co.sdt.herb.hw4

  val fileName = hw4.resourcesDir + "/finance.csv"
  val csvFileOpt = CSVFile.ofName(fileName)
  csvFileOpt match {
    case Some(cf) =>
      cf.split1()
      cf.split2()
    case None => println(s"File $fileName not found")
  }
}

object CSVFile {
  def apply(file: JFile): CSVFile = {
    new CSVFile(file)
  }

  def ofName(fileName: String): Option[CSVFile] = {
    val file = hw4.File.ofName(fileName)
    file match {
      case Some(f) => Some(new CSVFile(f))
      case None => None
    }
  }
}

class CSVFile(file: JFile) extends TextFile(file) {

  def split1(): Unit = {
    println("Month|Income|Expenses|Profit")
    for (line <- source.getLines) {
      val cols = line.split(",").map(_.trim)
      // do whatever you want with the columns here
      println(s"${ cols(0) }|${ cols(1) }|${ cols(2) }|${ cols(3) }")
    }
    source.close
  }

  def split2(): Unit = {
    println("Month|Income|Expenses|Profit")
    for (line <- source.getLines) {
      val Array(month, income, expenses, profit) = line.split(",").map(_.trim)
      // do whatever you want with the columns here
      println(s"${ month }|${ income }|${ expenses }|${ profit }")
    }
    source.close
  }
}