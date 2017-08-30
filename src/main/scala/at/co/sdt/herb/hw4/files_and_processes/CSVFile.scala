package at.co.sdt.herb.hw4.files_and_processes

import scala.io.BufferedSource

object CSVFile extends App {

  import at.co.sdt.herb.hw4

  val srcFile = hw4.resourcesDir + "/finance.csv?"
  new CSVFile(srcFile).split1()
}

class CSVFile(fileName: String) {

  val bufferedSource: Option[BufferedSource] = Some(io.Source.fromFile(fileName))

  def split1(): Unit = {

    println("Month|Income|Expenses|Profit")
    /* for (source <- buf
      line
    <- bufferedSource.getLines
    )
    {
      val cols = line.split(",").map(_.trim)
      // do whatever you want with the columns here
      println(s"${ cols(0) }|${ cols(1) }|${ cols(2) }|${ cols(3) }")
    }
    bufferedSource.close */
  }
}