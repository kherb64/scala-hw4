package at.co.sdt.herb.hw4.cmdline.scaladoc

/** A class to represent a ''human being''.
  *
  * Specify the `name`, `age`, and `weight` when creating a new `Person`,
  * then access the fields like this:
  * {{{
  * val p = Person("Al", 42, 200.0)
  * p.name
  * p.age
  * p.weight
  * }}}
  *
  * Did you know: The [[at.co.sdt.herb.hw4.cmdline.scaladoc.Employee]] extends this class.
  *
  * @constructor Create a new person with a `name`, `age`, and `weight`.
  * @param name   The person's name.
  * @param age    The person's age.
  * @param weight The person's weight.
  * @author Alvin Alexander
  * @version 1.0
  * @todo Add more functionality.
  * @see See [[http://alvinalexander.com alvinalexander.com]] for more
  *      information.
  */
class Person(val name: String, age: Int, @deprecated("The `weight` field is going away", "1.0") weight: Double) {

  /**
    * @constructor Alternatively create a new person with a `name` only.
    * @param name The person's name.
    */
  def this(name: String) {
    this(name, 0, 0.0)
  }

  /**
    * @return Returns a greeting based on the `name` field.
    */
  def greet: String = s"Hello, my name s $name"
}

/**
  * @constructor Create a new `Employee` by specifying its `name`, `age`,
  *              and `role`.
  * @param name The employee's name.
  * @param age  The employee's age.
  * @param role The employee's role in the organization.
  * @example val e = Employee("Al", 42, "Developer")
  */
class Employee(override val name: String, age: Int, role: String) extends Person(name, age, 0) {
  /**
    * @throws Exception Throws a [[java.lang.Exception]] 100% of the time, be careful!
    */
  @throws(classOf[Exception])
  def boom(): Nothing = {
    throw new Exception("boom")
  }

  /**
    * @return Returns a formal greeting based on the `name` field.
    */
  override def greet: String = s"Nice to meet you, my name is $name"

  /**
    * @return Returns a greeting based on the `other` and `name` fields.
    * @param other The name of the person we're greeting.
    */
  def greet(other: String): String = s"Hello $other, my name is $name"
}