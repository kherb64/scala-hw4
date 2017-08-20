package at.co.sdt.herb.hw4.collections

import scala.collection.GenSet

package enumerations {

  object Margin extends Enumeration {
    // TODO: what is this type for?
    type Margin = Value
    val Top, Bottom, Left, Right = Value
  }

}

// a much "heavier" approach
package enumerations.heavy {

  trait Margin

  case object Top extends Margin

  case object Right extends Margin

  case object Bottom extends Margin

  case object Left extends Margin

}

object MarginMain extends App {
  val margins = enumerations.Margin.values
  //margins.foreach(println)

  import enumerations.heavy._

  val margins2 = Set(Top, Bottom, Left, Right)
  //margins2.foreach(println)

  // (margins.toList diff margins2.toList).foreach(println)
  println(margins.mkString(","))
  println(margins2.mkString(","))
  //TODO: howto comapre two sets?
  //println(margins diff margins2.toSet)

}

