package hw4

/**
  * Created by herb on 09.10.16.
  */
class ComplexSpec extends UnitSpec {

  "A real number" should "have 0 as imaginary part" in {
    assert(new Complex(0, 0).im == 0)
    assert(new Complex(1, 0).im == 0)
    assert(new Complex(2, 0).im == 0)
    assert(new Complex(-1, 0).im == 0)
    assert(new Complex(-2, 0).im == 0)
  }

  it should "have itself as a real part" in {
    assert(new Complex(0, 0).re == 0)
    assert(new Complex(1, 0).re == 1)
    assert(new Complex(2, 0).re == 2)
    assert(new Complex(-1, 0).re == -1)
    assert(new Complex(-2, 0).re == -2)
  }

  "An imaginary number" should "have itself as imaginary part" in {
    assert(new Complex(0, 0).im == 0)
    assert(new Complex(0, 1).im == 1)
    assert(new Complex(0, 2).im == 2)
    assert(new Complex(0, -1).im == -1)
    assert(new Complex(0, -2).im == -2)
  }

  it should "have 0 as real part" in {
    assert(new Complex(0, 0).re == 0)
    assert(new Complex(0, 1).re == 0)
    assert(new Complex(0, 2).re == 0)
    assert(new Complex(0, -1).re == 0)
    assert(new Complex(0, -2).re == 0)
  }

  "A complex number of 0" should "throw an exception when reading phi" in {
    assertThrows[IllegalArgumentException] {
      new Complex(0, 0).phi
    }
  }

  "A complex number on the first meridian" should "have an equal real and imaginary part" in {
    assert(new Complex(0, 0).im == new Complex(0, 0).re)
    assert(new Complex(1, 1).im == new Complex(1, 1).re)
    assert(new Complex(2, 2).im == new Complex(2, 2).re)
    assert(new Complex(-1, -1).im == new Complex(-1, -1).re)
    assert(new Complex(-2, -2).im == new Complex(-2, -2).re)
  }

  it should "have a phi of pi/4 or 5*pi/4" in {
    assert(new Complex(1, 1).phi == math.Pi / 4)
    assert(new Complex(2, 2).phi == math.Pi / 4)
    assert(new Complex(-1, -1).phi == 5*math.Pi / 4)
    assert(new Complex(-2, -2).phi == 5*math.Pi / 4)
  }

  "A complex number on the second meridian" should "have an equal real and imaginary part" in {
    assert(new Complex(0, 0).im == -new Complex(0, 0).re)
    assert(new Complex(-1, 1).im == -new Complex(-1, 1).re)
    assert(new Complex(-2, 2).im == -new Complex(-2, 2).re)
    assert(new Complex(1, -1).im == -new Complex(1, -1).re)
    assert(new Complex(2, -2).im == -new Complex(2, -2).re)
  }

  it should "have a phi of 3*pi/4 or 7*pi/4" in {
    assert(new Complex(-1, 1).phi == 3 * math.Pi / 4)
    assert(new Complex(-2, 2).phi == 3 * math.Pi / 4)
    assert(new Complex(1, -1).phi == 7 * math.Pi / 4)
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


  /* it should "produce NoSuchElementException when head is invoked" in {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  } */
}
