object Binding {

  def main(args: Array[String]) {
    println(map)
    println(flatMap)
  }

  def flatMap: List[Int] = {
    val strs = List("1", "two", "3", "four", "five")
    val nums = strs.flatMap { s =>
      try {
        List(s.toInt)
      } catch {
        case _: java.lang.NumberFormatException => Nil
      }
    }

    nums
  }

  def map: List[Int] = {
    val strs = List("1", "2", "3", "4", "5")
    val nums = strs.map { s => s.toInt }

    nums
  }

  def `yield`: List[Int] = {
    val strs = List("1", "2", "3", "4", "5")
    val nums = for (p <- strs) yield p.toInt

    nums
  }
}