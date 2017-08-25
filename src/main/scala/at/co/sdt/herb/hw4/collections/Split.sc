val x = List(15, 10, 5, 8, 20, 12)
val m1 = x.groupBy(_ > 10)
val m2 = x.groupBy(_ % 5)
// m2.apply(0)

val (l1, l2) = x.partition(_ > 10)
l1
l2

val women = List("Susi", "Kim", "Annabel")
val men = List("Bertl", "Karl", "Wolfgang", "GuessWho")

val (w, m) = (women zip men).unzip
w
m


