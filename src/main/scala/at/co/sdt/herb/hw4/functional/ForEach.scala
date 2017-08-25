package at.co.sdt.herb.hw4.functional

object ForEach extends App {
  val list10 = List.range[Int](0, 10)

  list10.foreach((i: Int) => print(i))
  list10.foreach((i) => print(i))
  list10.foreach(i => print(i))
  list10.foreach(print(_))
  list10.foreach(print)
}
