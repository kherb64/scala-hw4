package hw4.complex

import hw4.UnitSpec

/**
  * Created by herb on 09.10.16.
  */
class ComplexSpec extends UnitSpec {

  "A real number" should "have 0 as imaginary part" in {
    assert(new Complex(0, 0).im == 0)
    assert(new Complex(1, 0).im == 0)
  }

  it should "have itself as a real part" in {
    assert(new Complex(0, 0).re == 0)
    assert(new Complex(1, 0).re == 1)
  }

  "An imaginary number" should "have itself as imaginary part" in {
    assert(new Complex(0, 0).im == 0)
    assert(new Complex(0, 1).im == 1)
  }

  it should "have 0 as real part" in {
    assert(new Complex(0, 0).re == 0)
    assert(new Complex(0, 1).re == 0)
  }

  "A complex number of 0" should "throw an exception when reading phi" in {
    assertThrows[IllegalArgumentException] {
      new Complex(0, 0).phi
    }
  }

  "A complex number on the first meridian" should "have an equal real and imaginary part" in {
    assert(new Complex(0, 0).im == new Complex(0, 0).re)
    assert(new Complex(1, 1).im == new Complex(1, 1).re)
    assert(new Complex(-1, -1).im == new Complex(-1, -1).re)
  }

  it should "have a phi of pi/4 or 5*pi/4" in {
    assert(new Complex(1, 1).phi == math.Pi / 4)
    assert(new Complex(-1, -1).phi == 5 * math.Pi / 4)
  }

  "A complex number on the second meridian" should "have an equal real and imaginary part" in {
    assert(new Complex(0, 0).im == -new Complex(0, 0).re)
    assert(new Complex(-2, 2).im == -new Complex(-2, 2).re)
    assert(new Complex(2, -2).im == -new Complex(2, -2).re)
  }

  it should "have a phi of 3*pi/4 or 7*pi/4" in {
    assert(new Complex(-2, 2).phi == 3 * math.Pi / 4)
    assert(new Complex(2, -2).phi == 7 * math.Pi / 4)
  }

  "Any complex number" should "throw an ArithmeticException when divided by zero" in {
    assertThrows[ArithmeticException] {
      new Complex(1, 1) / 0
    }
    assertThrows[ArithmeticException] {
      new Complex(1, 1) / 0.0
    }
    assertThrows[ArithmeticException] {
      new Complex(1, 1) / new Complex(0, 0)
    }
  }

  "Complex numbers" should "add their re/im respectively" in {
    assert(new Complex(1, 1) + new Complex(1, 0) == new Complex(2, 1))
    assert(new Complex(2, -1) + new Complex(0, 1) == new Complex(2, 0))
  }

  they should "add their re with non-complex numbers" in {
    assert(new Complex(1, 1) + 2 == new Complex(3, 1))
    assert(new Complex(1, 1) + 3.0 == new Complex(4, 1))
  }

  "Complex numbers" should "subtract their re/im respectively" in {
    assert(new Complex(1, 1) - new Complex(1, 0) == new Complex(0, 1))
    assert(new Complex(2, -1) - new Complex(0, 1) == new Complex(2, -2))
  }

  they should "subtract their re with non-complex numbers" in {
    assert(new Complex(1, 1) - 2 == new Complex(-1, 1))
    assert(new Complex(1, 1) - 3.0 == new Complex(-2, 1))
  }

  "Complex numbers" should "multiply in a correct way" in {
    assert(new Complex(1, 1) * new Complex(0, 0) == new Complex(0, 0))
    assert(new Complex(2, 2) * new Complex(1, 0) == new Complex(2, 2))
    assert(new Complex(3, 3) * new Complex(0, 1) == new Complex(-3, 3))
    assert(new Complex(3, 4) * new Complex(5, 2) == new Complex(7, 26))
  }

  they should "multiply their re+im with non-complex numbers" in {
    assert(new Complex(1, 1) * 2 == new Complex(2, 2))
    assert(new Complex(1, -1) * 3.0 == new Complex(3, -3))
  }

  "Complex numbers" should "divide in a correct way" in {
    assert(new Complex(2, 2) / new Complex(1, 0) == new Complex(2, 2))
    assert(new Complex(3, 3) / new Complex(0, 1) == new Complex(3, -3))
  }

  they should "divide their re+im with non-complex numbers" in {
    assert(new Complex(2, 2) / 2 == new Complex(1, 1))
    assert(new Complex(-6, 3) / 3.0 == new Complex(-2, 1))
    assert(new Complex(-5, 10) / new Complex(3, 4) == new Complex(1, 2))
  }
}