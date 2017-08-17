/**
  * A try on a trait
  */
sealed trait Name {
  val fName: String
  val lName: String
}

case class Person2(override val fName: String, override val lName: String) extends Name

case class Employee2(override val fName: String, override val lName: String, role: String) extends Name

val e2 = Employee2("Herbert", "Kreutzer", "Softwareentwickler")
e2.toString

val p3 = Person2("Bertl", "Bua")
