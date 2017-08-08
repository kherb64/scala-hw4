package hw4.traits

trait unneededDog {
  def speak(whatToSay: String)

  def wagTail(enabled: Boolean)
}

abstract class Animal {
  def speak()
}

trait WaggingTail {
  def startTail() { println("tail started") }

  def stopTail() { println("tail stopped") }
}

trait FourLeggedAnimal {
  def walk()

  def run()
}

class Dog extends Animal with WaggingTail with FourLeggedAnimal {
  override def speak(): Unit = { println("Dog says 'woof'") }

  override def walk(): Unit = { println("Dog is walking") }

  override def run(): Unit = { println("Dog is running") }
}