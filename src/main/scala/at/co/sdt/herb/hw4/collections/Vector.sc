val v = Vector("a", "b", "c")
v(0)

val a = Vector(1, 2, 3)
val b = a ++ Vector(45)

val c = v.updated(0, "x")

a.take(2)

var m = Vector[Any](1, 2, 3)
m = m ++ Vector(5)

m = m ++ Vector("e")

IndexedSeq(1, 2, 3)
