import scala.collection._ // weil default auch
// import scala.collection.mutable

val set = mutable.Set[Int]()
set += 1
set += (2, 3)


set ++= Vector(4, 5)

set.add(6)
set.add(5)

set += 2

set.contains(5)
set.contains(7)

set -= 1
set.retain(_ > 2)
set
set remove 1

set.take(2)

val sSet = SortedSet[Int](10, 9, 7, 4, 3, 2, 1)

