package at.co.sdt.herb.hw4.external_commands

import sys.process._

class ExternalCommand {
  def cmd(cmdName: String = ""): Int = {
    s"cmd.exe /c $cmdName".!
  }
}

object ExternalCommandDemo extends App {
  val ext = new ExternalCommand
  ext.cmd("dir")
  ext.cmd("dir \\temp")
}