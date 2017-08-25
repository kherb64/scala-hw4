import scala.collection._

// creating
class Person {
  override def toString: String = s"Person ${ this.hashCode() }"
}

val ints = mutable.Queue[Int]()
val fruits = mutable.Queue[String]()
val c = mutable.Queue[Person]()

val c2 = mutable.Queue(1, 2, 3)

//enqueue
val q = new mutable.Queue[String]
q += "apple"
q += ("kiwi", "banana")
q ++= List("cherry", "coconut")
q.enqueue("pineapple")
q

//dequeue
val next = q.dequeue
q
q.dequeue
q

q.dequeueFirst(_.startsWith("b"))
q
q.dequeueAll(_.length > 6)
q

val i = immutable.Queue[Int](1)
i enqueue("Burli", new Person)
val i2: immutable.Queue[Int] = i enqueue 2
