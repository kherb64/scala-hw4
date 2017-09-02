import java.io.{File => JFile}

import scala.sys.process._

val p = Process("bash --version")
val files = p.lineStream
files.foreach(println)

val javaProcs = ("ps auxw" #| "grep java" #| "wc -l").!!.trim

"bash -c pwd".!!
("find IdeaProjects -name *.scala" #| "wc -l").!!
Process("ls -la", new JFile("/tmp")).!!

val set = "bash -c set".!! // .split("\n").length

val stdout = new StringBuilder
val stderr = new StringBuilder
val status = Seq("find", "IdeaProjects", "-name", "*.scala") ! ProcessLogger(stdout append _, stderr append _)
println(status)
println("stdout: " + stdout)
println("stderr: " + stderr)
