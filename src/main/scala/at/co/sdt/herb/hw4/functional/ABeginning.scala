package at.co.sdt.herb.hw4.functional

object ABeginning extends App {
  private val list = List.range[Int](0, 10)
  println(s"list=$list")

  private val evens = list.filter((i: Int) => { i % 2 == 0 })
  println(s"evens=$evens")
  val evensShorter = list.filter(_ % 2 == 0)
  println(s"evensShorter=$evensShorter")

  // base method
  def isIntEven(i: Int): Boolean = { i % 2 == 0 }

  // 4 funcrtion value definitions
  val even: (Int) => Boolean = (i: Int) => isIntEven(i)
  private val even4 = (i: Int) => isIntEven(i)
  private val even5 = isIntEven _
  private val even6: Int => Boolean = isIntEven

  println(s"isIntEven=${ list.filter(isIntEven) }")
  println(s"even=${ list.filter(even) }")
  println(s"even4=${ list.filter(even4) }")
  println(s"even5=${ list.filter(even5) }")
  println(s"even6=${ list.filter(even6) }")

  // another function and it's combination
  val gt5: Int => Boolean = _ > 5
  val evenGt5: Int => Boolean = (i: Int) => even(i) && gt5(i)

  println(s"evenGt5=${ list.filter(evenGt5) }")
  println(s"even && gt5=${ list.filter(i => even(i) && gt5(i)) }")
}