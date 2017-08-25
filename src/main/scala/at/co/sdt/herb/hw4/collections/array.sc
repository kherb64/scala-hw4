import scala.util.Random

val fruits = Array("cherry", "apple", "banana")

import scala.util.Sorting

Sorting.quickSort(fruits)
fruits

val twoEmpty = Array.ofDim[Int](2, 3)
twoEmpty(1)
twoEmpty(0)
twoEmpty(0)(0)
twoEmpty(1)(1)

val uuid = java.util.UUID.randomUUID
val digits = uuid.toString.filter(_.isDigit)
val big = BigInt(digits) % Long.MaxValue
val seed: Long = big.toLong
val r = Random
r.setSeed(seed)

val twoFill = Array.fill[Int](2, 3)(r.nextInt(100))
twoFill(0)
twoFill(1)
twoFill(0)(0)
twoFill(1)(1)
