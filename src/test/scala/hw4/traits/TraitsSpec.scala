package hw4.traits

import hw4.UnitSpec

/**
  * Created by herb on 14.07.2017.
  */
class TraitsSpec extends UnitSpec {

  "Tests" should "be working" in {
    true shouldBe true
  }

  "14.7.2017" should "have a correct string representation" in {
    new Date(2017, 7, 14).toString() shouldBe "2017-7-14"
  }

  it should "have correct year, month, day" in {
    val d = new Date(2017, 7, 14)
    d.year shouldBe 2017
    d.month shouldBe 7
    d.day shouldBe 14
  }

  "A valid Date" should "have a year 1582 or after" in {
    assert(new Date(2017, 7, 14).year >= 1582)
    assert(new Date(1582, 7, 14).year >= 1582)
  }

  "14.7.1581" should "throw an illegal argument exception" in {
    assertThrows[IllegalArgumentException](new Date(1581, 7, 14))
  }

  "1.13.2017" should "throw an illegal argument exception" in {
    assertThrows[IllegalArgumentException](new Date(2017, 13, 1))
  }

  "1.-1.2017" should "throw an illegal argument exception" in {
    assertThrows[IllegalArgumentException](new Date(2017, -1, 1))
  }

  "-1.2.2017" should "throw an illegal argument exception" in {
    assertThrows[IllegalArgumentException](new Date(2017, 1, -1))
  }

  "32.1.2017" should "throw an illegal argument exception" in {
    assertThrows[IllegalArgumentException](new Date(2017, 1, 32))
  }

  "29.2.2017" should "throw an datetime exception" in {
    assertThrows[java.time.DateTimeException](new Date(2017, 2, 29))
  }

  /* "14.10.1582" should "throw an datetime exception" in {
    assertThrows[java.time.DateTimeException](new Date(1582, 10, 14))
  } */

  "15.10.1582" should "be a valid date" in {
    new Date(1582, 10, 15).toString() shouldBe "1582-10-15"
  }
}
