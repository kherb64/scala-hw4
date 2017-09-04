package at.co.sdt.herb.hw4.web_services

import net.liftweb.json._
import net.liftweb.json.JsonDSL._

case class Person2(name: String, address: Address2) {
  var friends: List[Person2] = Nil
}

case class Address2(city: String, state: String)

object LiftJsonLists1 extends App {
  //import net.liftweb.json.JsonParser._
  implicit val formats: DefaultFormats.type = DefaultFormats

  val merc = Person2("Mercedes", Address2("Somewhere", "KY"))
  val mel = Person2("Mel", Address2("Lake Zurich", "IL"))
  val friends = List(merc, mel)
  val p = Person2("Alvin Alexander", Address2("Talkeetna", "AK"))
  p.friends = friends

  // define the json output
  val json =
    "person2" ->
      ("name" -> p.name)
  "address2" ->
    ("city" -> p.address.city)
  "state" -> p.address.state
  "friends" ->
    friends.map { f =>
      "name" -> f.name
      "address" ->
        ("city" -> f.address.city)
      "state" -> f.address.state
    }

  // lift sucks println(pretty(render(json)))
  println(json)
}
