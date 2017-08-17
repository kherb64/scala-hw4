package at.co.sdt.herb.hw4.traits

trait PizzaTrait {
  var numToppings: Int // abstract
  var size = 14 // concrete
  val maxNumToppings = 10 // concrete
}

class Pizza extends PizzaTrait {
  var numToppings = 0 // override not needed because of var
  size = 16 // 'var' and 'override' not needed
  override val maxNumToppings = 11 // override and val needed because of val
}