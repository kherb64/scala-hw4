import scala.collection.mutable

val a = mutable.ArrayBuffer(3, 2, 1)

val b = a.sorted
a ++= Seq(7, 6, 5, 4)

b ++ a.sortBy(_ * -1)

b intersect a

a union b

a diff b
