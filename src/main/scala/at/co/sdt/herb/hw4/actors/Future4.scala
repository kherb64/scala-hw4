package at.co.sdt.herb.hw4.actors

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Future4 extends App {
  println("starting 3 futures")

  def calc(i: Int, j: Int): Future[Int] = Future {
    Thread.sleep(i)
    if (j == 2) throw new Exception("calc2 crashed!")
    i + j
  }

  val result1 = calc(400, 2)
  val result2 = calc(100, 21)
  val result3 = calc(100, 3)

  for {
    r1 <- result1
    r2 <- result2
    r3 <- result3
  } println(s"for $r1 $r2 $r3")

  for (ex <- result1.failed) println(s"result1 failed $ex")
  for (ex <- result2.failed) println(s"result2 failed $ex")
  for (ex <- result3.failed) println(s"result3 failed $ex")

  private def printAndSleep(a: Any, sleep: Long): Unit = {
    println(a)
    Thread.sleep(sleep)
  }

  printAndSleep("A", 100)
  printAndSleep("B", 100)
  printAndSleep("C", 100)
  printAndSleep("D", 100)
  printAndSleep("E", 100)
  printAndSleep("F", 100)

  Thread.sleep(200)

}

