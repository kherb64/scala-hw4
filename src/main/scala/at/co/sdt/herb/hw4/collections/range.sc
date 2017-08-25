1 to 10 mkString ","
1 until 10 mkString ","
1 to 10 by 2 mkString ","

'a' to 'c' mkString ","

for (i <- 1 to 3) println(i)

List.tabulate[Int](2)(_)

def d(i: Int, j: Int): Int = { i * 10 + j }
List.tabulate[Int](2, 3)(d)

val f1 = d _
val f2: (Int, Int) => Int = d

List.tabulate[Int](2, 3)(f1(_, _))
List.tabulate[Int](2, 3)(f1)

List.tabulate[Int](2, 3)(f2(_, _))
List.tabulate[Int](2, 3)(f2)

List.tabulate[Int](2, 3)((i, j) => i * 10 + j)
List.tabulate[Int](2, 3)(_ * 10 + _)
