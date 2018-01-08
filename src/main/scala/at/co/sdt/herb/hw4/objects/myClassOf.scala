package at.co.sdt.herb.hw4.objects

import scala.compat.Platform.currentTime

object myClassOf extends App {
  // println(s"${this.getClass} started at $executionStart")

  val hello = <p>Hello,
    world</p>
  println(hello.getClass)

  val hello2 = <p>Hello,
    <br/>
    world</p>
  println(hello.getClass)

  val sb = new StringBuilder
  hello.child.foreach(e => println(s"${ e.getClass } ${ e.text }"))
  hello2.child.foreach(e => {
    sb.clear
    println(s"${ e.getClass } ${ e.nameToString(sb) }=${ e.text }")
  })
  println(s"${ this.getClass.getSimpleName } took ${ currentTime - executionStart } ms")
}
