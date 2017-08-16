package hw4.traits


trait PizzaTrait2 {
  var numToppings: Int // abstract
  var size = 14 // concrete
  val maxNumToppings = 10 // concrete
}


class Pizza2 extends PizzaTrait2 {
  var numToppings = 0 // 'override' not needed
  size = 16 // 'var' and 'override' not needed
  override val maxNumToppings: Int = 9
  size = 15
}

object PizzaMain extends App {
  val p = new Pizza2()
  p.numToppings = 2
  println(s"maxNumToppings ${p.maxNumToppings}")
  println(s"numToppings ${p.numToppings}")
  println(s"size ${p.size}")
}