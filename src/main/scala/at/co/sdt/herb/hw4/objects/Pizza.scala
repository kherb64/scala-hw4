package at.co.sdt.herb.hw4.objects

import at.co.sdt.herb.hw4

/**
  * Pizza class
  */
class Pizza(var crustType: String) {
  override def toString: String = "Crust type is " + crustType
}

/**
  * companion object
  */
object Pizza {
  val CRUST_TYPE_THIN = "thin"
  val CRUST_TYPE_THICK = "thick"

  def getFoo = "Foo"

  def apply(crustType: String): Pizza = new Pizza(crustType)
}

object PizzaMain extends App {
  println(Pizza.CRUST_TYPE_THIN)
  println(Pizza.getFoo)

  //noinspection VarCouldBeVal
  var p = new Pizza(Pizza.CRUST_TYPE_THICK)
  println(p)

  val p2 = Pizza("burli")
  println(p2)

  hw4.hw4IsHere()
}