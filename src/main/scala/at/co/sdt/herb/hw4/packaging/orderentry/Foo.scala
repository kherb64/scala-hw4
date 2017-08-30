// a package containing a class named Foo
package at.co.sdt.herb.hw4.packaging.orderentry

class Foo {
  override def toString = "I am orderentry.Foo"
}

// a simple object to test the packages and classes
object Foo extends App {
  println(new Foo)
  println(new Foo)
  println(new Foo)
}