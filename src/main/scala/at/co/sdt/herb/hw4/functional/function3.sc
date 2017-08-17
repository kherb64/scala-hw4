val concat3 = (i: Int, j: Int, k: Int) => i.toString + j.toString + k.toString

val c0 = concat3(_: Int, _: Int, _: Int)
c0(_: Int, _: Int, _: Int)

val c1 = c0(1, _: Int, _: Int)
c1(2, _: Int)

val c2 = c1(_: Int, 2)
c2(3)
