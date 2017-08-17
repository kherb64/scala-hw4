/**
  * @param name Name of Pet
  */
abstract class Pet(name: String) {
  /**
    * abstract val
    */
  val greeting: String
  /**
    * concrete val
    */
  var hello: String = "Hello"
}

/**
  * subclass of Pet
  *
  * @param name Name of Pet
  */
class Dog(name: String) extends Pet(name) {
  /**
    * conctrete field to abstract val
    */
  val greeting = "Woof"
  /**
    * use of Pet field hello
    */
  hello = "helo"
}

val dog = new Dog("Fido")
dog.greeting


