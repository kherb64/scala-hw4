package hw4.complex

import hw4.complex.Complex.CoordType

/**
  * A class for complex numbers providing the 4 basic mathematical operations.
  */
class Complex(val re: Double, val im: Double) {

  def rad: Double = math.sqrt(re * re + im * im)

  def phi: Double = {
    if (im == 0 && re == 0) throw new IllegalArgumentException("Divide by 0")
    else if (im == 0) 0.0
    else {
      val z = math.atan2(im, re)
      if (z > 0) z
      else z + 2 * math.Pi
    }
  }

  override def toString: String = {
    val ph = phi / (math.Pi / 2.0)
    val imSign: String = if (math.signum(im) == -1) "" else "+"

    //f"($re%4.2f$imSign$im%4.2fj) ($rad%4.2f+$ph%4.2fπ/2)"

    def repr(prefix: String, coeff: Double, postfix: String): String = coeff match {
      case 0.0 => ""
      case 1.0 if postfix > "" => postfix
      case 1.0 => "1"
      case -1.0 if postfix > "" => "-" + postfix
      case _ if coeff.isWhole() => prefix + coeff.toInt.toString + postfix
      case _ => prefix + coeff.toString + postfix
    }

    repr("", re, "") + repr(imSign, im, Complex.imaginaryNotation.toString) + " " + f"($rad%4.2f+$ph%4.2fπ/2)"

  }

  override def equals(obj: scala.Any): Boolean = obj match {
    case obj: Complex => re == obj.re && im == obj.im
    case _ => false
  }

  def +(a: Any): Complex = a match {
    case c: Complex => new Complex(re + c.re, im + c.im)
    case r: Double => new Complex(re + r, im)
    case f: Float => new Complex(re + f, im)
    case i: Int => new Complex(re + i, im)
    case l: Long => new Complex(re + l, im)
  }

  def -(x: Any): Complex = x match {
    case c: Complex => new Complex(re - c.re, im - c.im)
    case r: Double => new Complex(re - r, im)
    case i: Int => new Complex(re - i, im)
  }

  def *(x: Any): Complex = x match {
    case c: Complex => new Complex(re * c.re - im * c.im, re * c.im + im * c.re)
    case r: Double => new Complex(re * r, im * r)
    case i: Int => new Complex(re * i, im * i)
  }

  def /(x: Any): Complex = x match {
    case c: Complex =>
      if (c.rad == 0.0) throw new ArithmeticException("/ by zero")
      else
        new Complex(re * c.re + im * c.im, -re * c.im + im * c.re) / (c.re * c.re + c.im * c.im)
    case r2: Double =>
      if (r2 == 0.0) throw new ArithmeticException("/ by zero")
      else
        new Complex(re / r2, im / r2)
    case i2: Int =>
      if (i2 == 0) throw new ArithmeticException("/ by zero")
      else
        new Complex(re / i2, im / i2)
  }
}

object Complex {

  object CoordType extends Enumeration {
    type CoordType = Value

    val Cartesian, Polar = Value
  }

  object ImaginaryNotation extends Enumeration {
    type ImaginaryNotation = Value

    val i, j = Value
  }

  val coordType: CoordType.Value = CoordType.Cartesian
  val imaginaryNotation: ImaginaryNotation.Value = ImaginaryNotation.j

  def apply(d1: Double, d2: Double, t: CoordType.Value = coordType): Complex = {

    t match {
      case CoordType.Cartesian =>
        new Complex(d1, d2)

      case CoordType.Polar =>
        new Complex(d1 * math.cos(d2),
          d1 * math.sin(d2))
      case _ => throw new IllegalArgumentException("Unknown Type " + t)
    }

  }
}