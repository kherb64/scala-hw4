

val i = 0

class Person {
  protected var fName: String = _
  protected var lName: String = _

  def setFirstName(name: String): this.type = {
    this.fName = name
    this
  }

  def setLastName(name: String): this.type = {
    this.lName = name
    this
  }

  override def toString: String = s"$fName $lName"
}

class Employee extends Person {
  protected var role: String = _

  def setRole(role: String): this.type = {
    this.role = role
    this
  }

  override def toString: String = s"$fName $lName $role"
}

val e = new Employee
e.setFirstName("Herbert")
  .setLastName("Kreutzer")
  .setRole("Softwareentwickler")

val p = new Person
p.setLastName("Bua")
  .setFirstName("Bertl")
