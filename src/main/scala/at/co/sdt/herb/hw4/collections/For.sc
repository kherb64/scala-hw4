val fruits = Array("apple", "banana", "orange")

for (f <- fruits) {
  println(f)
}

for (f <- fruits) {
  println(f)
}

for (i <- fruits.indices) {
  println(s"element $i is ${ fruits(i) }")
}

val largeFruits = for (e <- fruits) yield e.toUpperCase

val capitalizedFruits = for (fruit <- fruits) yield {
  // imagine this required multiple lines
  val upper = fruit.capitalize
  upper
}

type Vector1 = Array[Double]

def scalProd(v1: Vector1, v2: Vector1): Double = {
  /* var acc = 0.0
  for ((x, y) <- v1 zip v2) acc = acc + x * y
  acc */

  (for ((x, y) <- v1 zip v2) yield x * y).sum

  def mulT(tuple: (Double, Double)) = { tuple._1 * tuple._2 }

  (v1 zip v2).map(mulT) sum

  (v1 zip v2).map(t => t._1 * t._2) sum
}

scalProd(Array(1, 2), Array(2, 3))

