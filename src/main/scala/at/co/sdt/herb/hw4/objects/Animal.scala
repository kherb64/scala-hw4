package at.co.sdt.herb.hw4.objects

trait Animal {
  def speak(): Unit

}

object Animal {

  // Dog is more public
  class Dog() extends Animal {
    override def speak(): Unit = println("woof")
  }

  object Dog {
    def apply(): Dog = new Dog()
  }

  // Cat is more private
  private class Cat extends Animal {
    override def speak(): Unit = println("meow")
  }

  private object Cat {
    def apply(): Cat = new Cat()
  }

  sealed trait Typ

  case object BertlTyp extends Typ

  case object DogTyp extends Typ

  case object CatTyp extends Typ

  // the factory method
  def apply(t: Typ): Option[Animal] = {
    t match {
      case DogTyp => Some(Dog())
      case CatTyp => Some(Cat())
      case BertlTyp => None
    }
  }
}

object AnimalMain extends App {

  import Animal._

  println(new Dog())
  // println(new Cat()) // hidden by private class

  println(Dog())
  // println(Animal.Cat()) // hidden by private object

  // factory
  val dog = Animal(DogTyp).get
  println(dog)
  dog.speak()
  val cat = Animal(CatTyp).get
  println(cat)
  cat.speak()
  val bertl = Animal(Animal.BertlTyp).get
  println(bertl)
  bertl.speak()

}