case class Person(name: String, relation: String)

val p1 = Person("p", "r")
val p2 = Person("p", "r")

p1 == p2

val p3 = p1.copy()

p3 == p2
