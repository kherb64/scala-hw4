package at.co.sdt.herb.hw4.functional

/**
  * An object to test Newton's method.
  * Start with (a) the desired f(x) and f'(x) equations,
  * (b) an initial guess and (c) tolerance values.
  */
object NewtonsMethod extends App {
  // helper functions for beautiful reading
  val sin = (x: Double) => math.sin(x)
  val cos = (x: Double) => math.cos(x)
  val ePow = (x: Double) => math.pow(math.E, x)

  // the f(x) and f'(x) functions
  val fx = (x: Double) => 3 * x + sin(x) - ePow(x)
  val fxPrime = (x: Double) => 3 + cos(x) - ePow(x)

  // pass f(x) and f'(x) to the Newton's Method function, along with
  // the initial guess and tolerance
  val initialGuess = 1.0
  val tolerance = 0.01
  val tolerancePrime = 0.01
  val answer = new NewtonsMethod().newtonsMethod(fx, fxPrime, initialGuess, tolerance, tolerancePrime)
  println(answer)
}

class NewtonsMethod {

  /**
    * Newton's Method for solving equations.
    */
  def newtonsMethod(
    fx: (Double) => Double,
    fxPrime: (Double) => Double,
    x: Double,
    tolerance: Double,
    tolerancePrime: Double): Double = {

    var x1 = x
    var xNext = newtonsMethodHelper(fx, fxPrime, x1)
    // check that |f(xNext)| is greater than a second tolerance value
    while (math.abs(xNext - x1) > tolerance && math.abs(xNext) > tolerancePrime) {
      x1 = xNext
      println(xNext)
      xNext = newtonsMethodHelper(fx, fxPrime, x1)
    }

    xNext
  }

  /**
    * This is the "x2 = x1 - f(x1)/f'(x1)" calculation
    */
  private def newtonsMethodHelper(
    fx: (Double) => Double,
    fxPrime: (Double) => Double,
    x1: Double): Double = {

    // check that f'(x) != 0
    assert(fxPrime(x1) != 0.0, "fxPrime must not be 0.0")
    x1 - fx(x1) / fxPrime(x1)
  }

}
