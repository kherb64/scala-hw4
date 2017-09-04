package at.co.sdt.herb.hw4.collections.enumerations

object MarginMain extends App {
  val margins = Margin.values
  //margins.foreach(println)

  import heavy._

  val margins2 = Set(Top, Bottom, Left, Right)
  //margins2.foreach(println)

  // (margins.toList diff margins2.toList).foreach(println)
  println(margins.mkString(","))
  println(margins2.mkString(","))
  //howto compare two sets? simply with ==
  println(margins == margins2)

}

