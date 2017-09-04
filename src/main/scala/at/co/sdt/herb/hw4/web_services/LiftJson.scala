package at.co.sdt.herb.hw4.web_services

import net.liftweb.json.Serialization.write
import net.liftweb.json._

case class Person(name: String, address: Address)

case class Address(city: String, state: String)

object LiftJsonTest extends App {
  val p = Person("Alvin Alexander", Address("Talkeetna", "AK"))

  // create a JSON string from the Person, then print it
  implicit val formats: DefaultFormats.type = DefaultFormats
  val jsonString = write(p)
  println(jsonString)
}