import scala.io.Source

//concise
val filename = "textfile.txt"
/*
for (line <- Source.fromFile(filename).getLines) {
  println(line)
}

val lines = Source.fromFile("/Users/Al/.bash_profile").getLines.toList
val lines = Source.fromFile("/Users/Al/.bash_profile").getLines.toArray

val fileContents = Source.fromFile(filename).getLines.mkString
*/

// properly closing file
/*
val bufferedSource = Source.fromFile(filename)
for (line <- bufferedSource.getLines) {
  println(line.toUpperCase)
}
bufferedSource.close
*/