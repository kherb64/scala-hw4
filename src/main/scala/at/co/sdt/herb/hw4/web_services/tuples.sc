import net.liftweb.json.JsonAST

case class Address(street: String, zip: String, city: String)

case class Person(name: String, var age: Int, var address: Address)

val p = Person("Bertl", 53, Address("Spiegelhofergasse 7", "2380", "Perchtoldsdorf"))

import net.liftweb.json._

parse(""" { "numbers" : [1, 2, 3, 4] } """)

/* val json1 = List(1, 2, 3)
// TODO: why does this not compile?
compact(render(json1)) */

/* val json: (String, JsonAST.JObject) = ("person" ->
  ("name" -> p.name) ~
    ("age" -> p.age))
// TODO: why does this not compile?
pretty(render()) */