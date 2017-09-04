package at.co.sdt.herb.hw4.web_services

import spray.json._

object SprayJson {

  def apply(): SprayJson = new SprayJson
}

class SprayJson {
  def basic(): Unit = {

    // basic
    val source =
      """{ "some": "JSON source" }"""
    val jsonAst = source.parseJson // or JsonParser(source)
    println(s"basic $jsonAst")
    val jsonPretty = jsonAst.prettyPrint // or .compactPrint
    println(jsonPretty)
    val jsonCompact = jsonAst.compactPrint
    println(jsonCompact)
  }

  def some(): Unit = {

    case class Some(some: String)

    object SomeJsonProtocol extends DefaultJsonProtocol {
      implicit val someFormat: RootJsonFormat[Some] = jsonFormat1(Some)
    }

    val source =
      """{ "some": "JSON source" }"""
    val jsonAst = source.parseJson // or JsonParser(source)

    import SomeJsonProtocol._
    val myObject = jsonAst.convertTo[Some]
    println(s"some $myObject")
  }

  def list(): Unit = {

    import DefaultJsonProtocol._
    // scala objects
    val jsonAst2 = List(1, 2, 3).toJson
    println(s"list ${ jsonAst2.prettyPrint }")

    val myObject2 = jsonAst2.convertTo[List[Int]]
    println(myObject2)
  }

  def person(): Unit = {
    case class Address(street: String, zip: String, city: String)
    case class Person(name: String, var age: Int, var address: Address)

    object AddressJsonProtocol extends DefaultJsonProtocol {
      implicit val AddressFormat: JsonFormat[Address] = lazyFormat(jsonFormat3(Address))
      // es darf nut einen geben!
      // implicit val AddressFormat2: JsonFormat[Address] = lazyFormat(jsonFormat(Address, "straße", "plz", "ort"))
    }

    import AddressJsonProtocol._
    object PersonJsonProtocol extends DefaultJsonProtocol {
      implicit val PersonFormat: JsonFormat[Person] = lazyFormat(jsonFormat3(Person))
    }


    val a = Address("Spiegelhofergasse 7", "2380", "Perchtoldsdorf")
    val aj = a.toJson
    val a2 = aj.convertTo[Address]
    println(s"a $a")
    println(s"aj $aj")
    println(s"a2 $a2: ${ a == a2 }")

    import PersonJsonProtocol._
    val p = Person("Bertl", 53, a)
    val pj = p.toJson
    val p2 = pj.convertTo[Person]
    println(s"p $p")
    println(s"j $pj")
    println(s"p2 $p2: ${ p == p2 }")

  }
}

object SprayJsonDemo extends App {
  val spray = SprayJson()
  spray.basic()
  spray.some()
  spray.list()
  spray.person()
}