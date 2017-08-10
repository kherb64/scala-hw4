package hw4.classes

import Pizza._
import hw4.UnitSpec2

class PizzaSpec extends UnitSpec2 {

  "Tests are working" in {
    true shouldBe true
  }

  "initialization tests" - {
    "default pizza w/o any modifications" in initTest(new Pizza())
    "pizza with initial size" in {
      val size = 14
      initTest(new Pizza(size), size)
    }
    "pizza with initial crust" in {
      val crust = "NAPOLI"
      initTest(new Pizza(crustType = crust), iniCrust = crust)
    }
    "pizza with initial size and crust" in {
      val size = 53
      val crust = "BERTL"
      initTest(new Pizza(size, crust), size, crust)
    }
  }

  "modification tests" - {
    "change size" in {
      val p = new Pizza()
      for (s <- List(15, 14, 16)) {
        modiSize(p, s)
      }
    }
    "change crust" in {
      val p = new Pizza()
      for (c <- List("THICK", "SLICK", "EMPTY")) {
        modiCrust(p, c)
      }
    }
    "change size and crust" in {
      val p = new Pizza()
      for {
        s <- List(15, 14, 16)
        c <- List("THICK", "SLICK", "EMPTY")
      } {
        modiSize(p, s)
        modiCrust(p, c)
      }
    }
    "change size or crust" in {
      val p = new Pizza()
      modiSize(p, 16)
      modiCrust(p, "Very Thin")
      modiSize(p, -2)
      modiCrust(p, "Lightyears")
    }
  }

  def initTest(
    p: Pizza,
    iniSize: Int = DEFAULT_CRUST_SIZE,
    iniCrust: String = DEFAULT_CRUST_TYPE): Unit = {

    p should not be null

    p.isInstanceOf[Pizza] shouldBe true

    p.crustSize shouldBe iniSize

    p.crustType shouldBe iniCrust

    readTest(p)

  }

  def modiSize(
    p: Pizza,
    newSize: Int): Unit = {

    // println(s"${ p.crustSize },${ p.crustType } => $newSize,${ p.crustType }")

    p.crustSize = newSize
    p.crustSize shouldBe newSize
    readTest(p)

  }

  def modiCrust(
    p: Pizza,
    newCrust: String): Unit = {
    // println(s"${ p.crustSize },${ p.crustType } => ${ p.crustSize },$newCrust")

    p.crustType = newCrust
    p.crustType shouldBe newCrust
    readTest(p)

  }

  /**
    * Tests Pizza.toString
    *
    * @param p Pizza instance
    */
  def readTest(p: Pizza): Unit = {
    //println(s"${ p.crustSize },${ p.crustType }")

    // val t = s"A ${ p.crustSize } inch pizza with a ${ p.crustType } crust"
    p.toString should include("pizza")
    p.toString should include(p.crustSize.toString)
    p.toString should include(p.crustType)
  }

}
