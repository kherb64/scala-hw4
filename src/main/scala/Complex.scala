package hw4

/**
  * A class for complex numbers providing the 4 basic mathematical operations.
  */
class Complex(val re: Double, val im: Double) {

  def rad = math.sqrt(re * re + im * im)

  def phi = {
    if (im == 0 && re == 0) throw new IllegalArgumentException("Divide by 0")
    else if (im == 0) 0.0
    else {
      val z = math.atan2(im, re)
      if (z > 0) z
      else z + 2 * math.Pi
    }
  }

  override def toString = {
    val ph = phi / (math.Pi / 2.0)
    val imSign: String = math.signum(im) match {
      case -1 => ""
      case _ => "+"
    }
    f"($re%4.2f$imSign$im%4.2fj) ($rad%4.2f+$ph%4.2fπ/2)"

  }

  override def equals(obj: scala.Any): Boolean = obj match {
    case obj: Complex => re == obj.re && im == obj.im
    case _ => false
  }

  def +(x: Any): Complex = x match {
    case c: Complex => new Complex(re + c.re, im + c.im)
    case r: Double => new Complex(re + r, im)
    case i: Int => new Complex(re + i, im)
    case _ => ???
  }

  def -(x: Any): Complex = x match {
    case c: Complex => new Complex(re - c.re, im - c.im)
    case r: Double => new Complex(re - r, im)
    case i: Int => new Complex(re - i, im)
    case _ => ???
  }

  def *(x: Any): Complex = x match {
    case c: Complex => new Complex((re * c.re - im * c.im), (re * c.im + im * c.re))
    case r: Double => new Complex(re * r, im * r)
    case i: Int => new Complex(re * i, im * i)
    case _ => ???
  }

  def /(x: Any): Complex = x match {
    case c: Complex =>
      if (c.rad == 0.0) throw new ArithmeticException("/ by zero")
      else
        new Complex((re * c.re + im * c.im), (-re * c.im + im * c.re)) / (c.re * c.re + c.im * c.im)
    case r2: Double =>
      if (r2 == 0.0) throw new ArithmeticException("/ by zero")
      else
        new Complex(re / r2, im / r2)
    case i2: Int =>
      if (i2 == 0) throw new ArithmeticException("/ by zero")
      else
        new Complex(re / i2, im / i2)
    case _ => ???
  }
}

object Complex {
  val Cartesian: String = "cartesian"
  val Polar: String = "polar"

  def apply(d1: Double, d2: Double, t: String = Complex.Cartesian) {

    t match {
      case Complex.Cartesian =>
        new Complex(d1, d2)

      case Complex.Polar =>
        new Complex(d1 * math.cos(d2),
          d1 * math.sin(d2))
      case _ => throw new IllegalArgumentException("Unknown Type " + t)
    }

  }
}