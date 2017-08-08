package hw4

import java.time.LocalDateTime

object Dates {

  val now: LocalDateTime = LocalDateTime.now()

  def main(args: Array[String]) {
    println(now)
    /* println(now.toLocalDate)
    println(now.toLocalTime) */

    val n1 = now
    val n2 = now
    println(n1.hashCode())
    println(n2.hashCode())
    println(n1 == n2)
  }
}
