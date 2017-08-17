object Person2 {
  def className(o: Any): String = o.getClass.getSimpleName
}

class Person2(private var _name: String) {
  def name = _name

  def name_=(newName: String) { _name = newName }

  override def toString: String = s"${ Person2.className(this) }($name)"
}

val john = new Person2("John")
john.name = "Bertl"
john

Person2.className(2)
Person2.className(2L)
Person2.className(Person2)
Person2.className(john)

case class Address(city: String, state: String) {
  //override def toString: String = s"$city $state"
}

class Person4(var name: String, var address: Address) {
  override def toString: String = s"$name@$address"
}

val n = new Person4("n", Address("c", "s"))

class Employee(name: String, address: Address, var age: Int)
  extends Person4(name, address) {
  override def toString: String = s"$name,$age@$address"
}

val karl = new Employee("Karl", Address("St.Pölten", "NÖ"), 46)
