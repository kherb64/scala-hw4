package hw4.numbers

import Numbers._

object Numbers {

  println("object Numbers")

  // not required to declare "throws NumberFormatException"
  def toIntOld(s: String): Int = s.toInt

  def toInt(s: String): Option[Int] = {
    try {
      Some(s.toInt)
    } catch {
      case NumberFormatException => None
    }
  }

}

class Numbers {
  println("class Numbers")

  def main(args: Array[String]) {
    val i = toInt("246") getOrElse 0
    println(i)
    val herb = toInt("herb") getOrElse 0
    println(herb)
  }
}