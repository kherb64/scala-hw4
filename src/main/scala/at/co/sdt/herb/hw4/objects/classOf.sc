

val stringClass = classOf[String]

stringClass.getDeclaredMethods.foreach(println(_))
// stringClass.getMethod("hashCode")
// stringClass.getMethod("charAt", int)
stringClass.getClass

val hello = <p>Hello,
  <br/>
  world</p>
hello.child.foreach(e => println(e.getClass))





def printClass(c: Any) { println(c.getClass) }
printClass(1)
printClass("yo")
