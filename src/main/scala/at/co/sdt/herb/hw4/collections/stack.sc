import scala.collection._

val ints = mutable.Stack[Int]()
val fruits = mutable.Stack[String]()

case class Person(name: String)

// old and bad val people = mutable.Stack[Person]()
val people = mutable.ArrayStack[Person]()
people.push(Person("Bertl"))
people.push(Person("Bua"))

people.pop()
people.pop()

people += Person("Bertl again")

// no mutlipush on ArrayStack people.push(Person("p1"), Person("p2"),Person("p3"),Person("p4"))
List(Person("p1"), Person("p2"), Person("p3"), Person("p4"))
  .foreach(people.push)
people.size
people.isEmpty
people.indices

people.pop()
people.pop()
val p2 = people.clone()
people.clear()
p2
