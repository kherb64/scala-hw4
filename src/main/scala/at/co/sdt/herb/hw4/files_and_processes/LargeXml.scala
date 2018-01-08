package at.co.sdt.herb.hw4.files_and_processes

import java.io.{ File => JFile }

import scala.sys.process._

/**
  * Works with large xml files on server
  */
class LargeXml(path: String) {

  def findLargest: String = {
    "bash -c pwd".!!
    ("find " + path + " -name *.xml" #| "wc -l").!!
    Process("ls -la", new JFile("/tmp")).!!
  }
}

object LargeXmlDemo extends App {
  val largestFut = new LargeXml("/apps").findLargest
  // largestFut.onComplete()
}