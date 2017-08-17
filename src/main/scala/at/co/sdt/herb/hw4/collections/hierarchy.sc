val v = Vector(1, 2, 3)
v.sum // 6
v.filter(_ > 1) // Vector(2, 3)
v.map(_ * 2)

val m = Map(1 -> "a", 2 -> "b")

val m2 = collection.mutable.Map(1 -> "a", 2 -> "b")

val set = Set(2, 3)
val set4 = set + 4
val set1 = set4 + 1
set1 - 4
set1.toList.sorted.reverse
set1.mkString(";")


var set3 = set1
set3 += 5
set3.mkString

set1 + 7

