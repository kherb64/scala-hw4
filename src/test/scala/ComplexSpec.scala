package hw4

/**
  * Created by herb on 09.10.16.
  */
class ComplexSpec extends UnitSpec {

  "A real Complex number" should "have an imaginary part of 0" in {
    assert(new Complex(0, 0).im == 0)
    assert(new Complex(1, 0).im == 0)
    assert(new Complex(2, 0).im == 0)
    assert(new Complex(-1, 0).im == 0)
    assert(new Complex(-2, 0).im == 0)
  }

  it should "have itself as a real part of 0" in {
    assert(new Complex(0, 0).im == 0)
    assert(new Complex(1, 0).im == 1)
    assert(new Complex(2, 0).im == 2)
    assert(new Complex(-1, 0).im == -1)
    assert(new Complex(-2, 0).im == -2)
  }

  /* it should "produce NoSuchElementException when head is invoked" in {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  } */
}
