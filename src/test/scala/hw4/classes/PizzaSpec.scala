package hw4.classes

import Pizza._
import hw4.UnitSpec2

class PizzaSpec extends UnitSpec2 {

  "Tests are working" in {
    true shouldBe true
  }

  "initialization tests" - {
    "default pizza w/o any modifications" in {
      initTest(new Pizza())
    }
    "pizza with initial size" in {
      val size = 14
      initTest(new Pizza(size), size)
    }
    "pizza with initial crust" in {
      //noinspection SpellCheckingInspection
      val crust = "NAPOLI"
      initTest(new Pizza(crustType = crust), iniCrust = crust)
    }
    "pizza with initial size and crust" in {
      val size = 53
      //noinspection SpellCheckingInspection
      val crust = "BERTL"
      initTest(new Pizza(size, crust), size, crust)
    }
  }

  "modification tests" - {
    val sizes = List(15, 14, 16)
    val crusts = List("THICK", "SLICK", "EMPTY")

    "change size" in {
      val p = new Pizza()
      for (s <- sizes) {
        modifySize(p, s)
      }
    }
    "change crust" in {
      val p = new Pizza()
      for (c <- crusts) {
        modifyCrust(p, c)
      }
    }
    "change size and crust" in {
      val p = new Pizza()
      for {
        s <- sizes
        c <- crusts
      } {
        modifySize(p, s)
        modifyCrust(p, c)
      }
    }
    "change size or crust" in {
      val p = new Pizza()
      modifySize(p, 16)
      modifyCrust(p, "Very Thin")
      modifySize(p, -2)
      //noinspection SpellCheckingInspection
      modifyCrust(p, "Lightyears")
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

  def modifySize(
    p: Pizza,
    newSize: Int): Unit = {

    // println(s"${ p.crustSize },${ p.crustType } => $newSize,${ p.crustType }")

    p.crustSize = newSize
    p.crustSize shouldBe newSize
    readTest(p)

  }

  def modifyCrust(
    p: Pizza,
    newCrust: String): Unit = {
    // println(s"${ p.crustSize },${ p.crustType } => ${ p.crustSize },$newCrust")

    p.crustType = newCrust
    p.crustType shouldBe newCrust
    readTest(p)

  }

  /**
    * Test Pizza.toString for plausibility
    *
    * @param p Pizza instance
    */
  def readTest(p: Pizza): Unit = {
    p.toString should include("pizza")
    p.toString should include(p.crustSize.toString)
    p.toString should include(p.crustType)
  }

}
