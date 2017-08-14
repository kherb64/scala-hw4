package hw4.objects

case class Person(var name: String, var age: Int)

// define two auxiliary constructors
object Person {
  def apply() = new Person("<no name>", 0)

  def apply(name: String) = new Person(name, 0)
}

object PersonMain extends App {
  println(new Person("Bertl", 53))
  println(Person("Bertl", 53))
  println(Person("Bertl"))
  println(Person)
}