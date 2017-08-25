import scala.collection.mutable

val fruits = mutable.ArrayBuffer[String]()
val ints = mutable.ArrayBuffer[Int]()

val nums = mutable.ArrayBuffer(1, 2, 3)
nums += 4
nums += (5, 6)
nums ++= List(7, 8)
val rev = nums.reverse
nums.clear()
nums ++= rev
nums -= 9
nums -= 5

val lb = mutable.ListBuffer[String]()
val ml = mutable.MutableList[String]()
