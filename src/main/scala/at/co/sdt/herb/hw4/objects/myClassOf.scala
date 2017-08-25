package at.co.sdt.herb.hw4.objects

import scala.compat.Platform.currentTime

object myClassOf extends App {
  // println(s"${this.getClass} started at $executionStart")

  val hello = <p>Hello,
    <br/>
    world</p>
  println(hello.getClass)

  hello.child.foreach(e => println(e.getClass))
  println(s"${ this.getClass } took ${ currentTime - executionStart } ms")
}
