import hw4.Complex.CoordType._
import hw4.Complex.ImaginaryNotation._
import hw4._

// val hw = new HelloWorld

val c1 = Complex(2, -2)
// Complex.imaginaryNotation = j
val c2 = Complex(1, -1, Cartesian)

c1 + c2
c1 - c2
c1 * c2
c1 / c2

c1 + 1l
c1 - 1
c1 * 2
c1 / 2

c1 + 1.1
c1 - 1.1
c1 * 2.2
c1 / 2.2

c1.re
c1.im
c1.rad
c1.phi / math.Pi

c2.re
c2.im
c2.rad
c2.phi / math.Pi

val c3 = Complex(math.sqrt(2), math.Pi / 4, Polar)
c3

2.1d.isWhole()