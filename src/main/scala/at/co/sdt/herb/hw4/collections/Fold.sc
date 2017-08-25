val a = Array(12, 6, 15, 2, 20, 9)


//noinspection SimplifiableFoldOrReduce
{
  a.reduceLeft(_ + _)
  a.reduceLeft(_ * _)
  a.reduceLeft(_ min _)
  a.reduceLeft(_ max _)
}

a.sum
a.product
a.min
a.max
a.maxBy(_ > 99)

val f = Seq(1, 1, 2, 2, 1)
f.scanLeft(0)(_ + _)
f.distinct
f.indices

