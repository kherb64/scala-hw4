package hw4.objects

trait Animal {
  def speak(): Unit
}

object Animal {

  private class Dog extends Animal {
    override def speak(): Unit = println("woof")
  }

  private class Cat extends Animal {
    override def speak(): Unit = println("meow")
  }

  sealed trait Typ

  case object DogTyp extends Typ

  case object CatTyp extends Typ

  // the factory method
  def apply(t: Typ): Animal = {
    t match {
      case DogTyp => new Dog
      case CatTyp => new Cat
    }
  }
}

object AnimalMain extends App {
  println(Animal(Animal.DogTyp))
  println(Animal(Animal.CatTyp))
  // println(Animal(Animal.Bertl))
}