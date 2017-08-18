def printIt(c: Char): Unit = { println(c) }
"HAL".foreach(c => printIt(c))
"HAL".foreach(printIt)

"HAL".foreach((c: Char) => println(c))
"HAL".foreach(println)

val longWords = new StringBuilder
"Hello world it's Al".split(" ").foreach { e =>
  if (e.length > 4) longWords.append(s" $e")
  else println("Not added: " + e)
}
longWords

val m = Map("fname" -> "Tyler", "lname" -> "LeDude")
m foreach println
