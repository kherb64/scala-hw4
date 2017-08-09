package hw4.classes

import hw4.UnitSpec2
import hw4.classes.Pizza._

class PizzaSpec extends UnitSpec2 {

  "Tests should be working" in {
    true shouldBe true
  }

  "Pizza() should" - {
    val p = new Pizza()
    val newSize = 15
    val newCrust = "THICK"

    "not be null" in {
      p should not be null
    }

    "be an instance of Pizza" in {
      p.isInstanceOf[Pizza] shouldBe true
    }

    s"have a default size of $DEFAULT_CRUST_SIZE" in {
      p.crustSize shouldBe DEFAULT_CRUST_SIZE
    }
    s"have a default type of $DEFAULT_CRUST_TYPE" in {
      p.crustType shouldBe DEFAULT_CRUST_TYPE
    }

    s"read A $DEFAULT_CRUST_SIZE inch pizza with a $DEFAULT_CRUST_TYPE crust" in {
      p.toString shouldBe s"A $DEFAULT_CRUST_SIZE inch pizza with a $DEFAULT_CRUST_TYPE crust"
    }

    s"have a new size of $newSize" in {
      p.crustSize = newSize
      p.crustSize shouldBe newSize
    }

    s"have a new $newCrust crust" in {
      p.crustType = newCrust
      p.crustType shouldBe newCrust
    }

    s"read A $newSize inch pizza with a $newCrust crust" in {
      p.toString shouldBe s"A $newSize inch pizza with a $newCrust crust"
    }

  }



}
