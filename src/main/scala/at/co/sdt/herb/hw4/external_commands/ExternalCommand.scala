package at.co.sdt.herb.hw4.external_commands

import scala.util.{ Success, Try }
import sys.process._

class ExternalCommand {
  def cmd(cmd: String = ""): Int = {
    Try(cmd.!) match {
      case Success(i) => i
      case _ => -1
    }
  }

  def shellCmd(cmdName: String = ""): Int = {
    cmd(s"cmd.exe /c $cmdName")
  }
}

object ExternalCommandDemo extends App {
  val ext = new ExternalCommand
  //ext.shellCmd(" dir ")
  //println(ext.shellCmd("dir \\temp"))
  ext.cmd("java -version")
  //println(ext.cmd("sbt version"))
  //val exitCode = Process("dir").!
  val p = Process("bash -c pwd")
  val files = p.!!.split(" ")
  println(files.mkString(", "))
}