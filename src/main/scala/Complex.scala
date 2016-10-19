package hw4

/**
  * Created by herb on 09.10.16.
  */
class Complex(t: String, d1: Double, d2: Double) {
  def this(real: Double, imaginary: Double) = this("cartesian", real, imaginary)

  var re: Double = _
  var im: Double = _

  t match {
    case "cartesian" => {
      re = d1
      im = d2
    }
    case "polar" => {
      re = d1 * math.cos(d2)
      im = d1 * math.sin(d2)
    }
    case _ => throw new IllegalArgumentException("Unknown Type " + t)
  }


  /* def Polar(radius: Double, phi: Double) = {
    re = radius * math.cos(phi)
    im = radius * math.sin(phi)
  } */

  def rad = math.sqrt(re * re + im * im)

  def phi = {
    if (im == 0 && re == 0) throw new IllegalArgumentException("Divide by 0")
    else
    if (im == 0) 0.0
    else {
      val z = math.atan2(im, re)
      if (z > 0) z
      else z + 2 * math.Pi
    }
  }

  override def toString = {
    val ph = phi * 2 / math.Pi
    f"($re%4.2f/$im%4.2f) ($rad%4.2f+$ph%4.2f pi/2)"
  }

  def +(c2: Complex): Complex = new Complex(re + c2.re, im + c2.im)

  def +(r2: Double): Complex = new Complex(re + r2, im)

  def +(i2: Int): Complex = new Complex(re + i2, im)

  def -(c2: Complex): Complex = new Complex(re - c2.re, im - c2.im)

  def -(r2: Double): Complex = new Complex(re - r2, im)

  def -(i2: Int): Complex = new Complex(re - i2, im)

  def *(c2: Complex): Complex = {
    // new Complex("polar", rad * c2.rad, phi + c2.phi)
    new Complex((re * c2.re - im * c2.im), (re * c2.im + im * c2.re))
  }

  def *(r2: Double): Complex = {
    // new Complex("polar", rad * c2, phi)
    new Complex(re * r2, im * r2)
  }

  def *(i2: Int): Complex = {
    // new Complex("polar", rad * c2, phi)
    new Complex(re * i2, im * i2)
  }

  def /(c2: Complex): Complex = {
    if (c2.rad == 0) throw new IllegalArgumentException("NaN")
    else
    //      new Complex("polar", rad / c2.rad, phi - c2.phi)
      new Complex((re * c2.re + im * c2.im), (-re * c2.im + im * c2.re)) / (c2.re * c2.re + c2.im * c2.im)
  }

  def /(r2: Double): Complex = {
    if (r2 == 0) throw new IllegalArgumentException("NaN")
    else
      new Complex(re / r2, im / r2)
  }

  def /(i2: Int): Complex = {
    if (i2 == 0) throw new IllegalArgumentException("NaN")
    else
      new Complex(re / i2, im / i2)
  }
}
