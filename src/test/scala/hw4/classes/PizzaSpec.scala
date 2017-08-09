package hw4.classes

import hw4.UnitSpec
import hw4.classes.Pizza._

class PizzaSpec extends UnitSpec {

  "Tests" should "be working" in {
    true shouldBe true
  }

  val p = new Pizza()
  s"Pizza()" should "not be null" in {
    p should not be null
  }

  "it" should "be an instance of Pizza" in {
    p.isInstanceOf[Pizza] shouldBe true
  }

  "it" should s"have a size of $DEFAULT_CRUST_SIZE" in {
    p.crustSize shouldBe DEFAULT_CRUST_SIZE
  }
  "it" should s"have a type of $DEFAULT_CRUST_TYPE" in {
    p.crustType shouldBe DEFAULT_CRUST_TYPE
  }

  "it" should s"read A $DEFAULT_CRUST_SIZE inch pizza with a $DEFAULT_CRUST_TYPE crust" in {
    p.toString shouldBe s"A $DEFAULT_CRUST_SIZE inch pizza with a $DEFAULT_CRUST_TYPE crust"
  }

  val newSize = 14
  "it" should s"have a new size of $newSize" in {
    p.crustSize = newSize
    p.crustSize shouldBe newSize
  }

  val newCrust = "THICK"
  "it" should s"read A $newSize inch pizza with a $newCrust crust" in {
    p.crustType = newCrust
    p.toString shouldBe s"A $newSize inch pizza with a $newCrust crust"
  }

}
