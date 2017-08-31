package at.co.sdt.herb.hw4.files_and_processes

import java.io.{ File => JFile }

import at.co.sdt.herb.hw4

import scala.util.{ Failure, Success, Try }

object Directory {
  def ofName(dirName: String): Option[Directory] = {
    val file = hw4.File.ofName(dirName)
    file match {
      case Some(f) =>
        val dir = Try(new Directory(f))
        dir match {
          case Success(d) => Some(d)
          case Failure(ex) =>
            println(ex)
            // ex.printStackTrace()
            None
        }
      case None => None
    }
  }
}

class Directory(val dir: JFile) {
  self =>

  require(dir.exists && dir.isDirectory, s"$dir must be a directory")
  // require(requirement = false, "test requirement")
  println(s"${ self.getClass } instantiated with $dir")

  def getListOfFiles: List[JFile] = {
    dir.listFiles.filter(_.isFile).toList
  }

  def getListOfSubDirectories: List[String] =
    dir.listFiles
      .filter(_.isDirectory)
      .map(_.getName)
      .toList
}

object ListFilesDemo extends App {
  val dirName = hw4.resourcesDir.getCanonicalPath

  for (dir <- Directory.ofName(dirName + "?")) {
    println(dir.getListOfFiles.mkString("\n"))
  }

  for (dir <- Directory.ofName(dirName + "txtfile.txt")) {
    println(dir.getListOfFiles.mkString("\n"))
  }

  for (dir <- Directory.ofName(dirName)) {
    println(dir.getListOfFiles.mkString("\n"))
  }

  for (dir <- Directory.ofName(hw4.projectDir.getCanonicalPath)) {
    println(dir.getListOfSubDirectories.mkString("\n"))
  }
}
