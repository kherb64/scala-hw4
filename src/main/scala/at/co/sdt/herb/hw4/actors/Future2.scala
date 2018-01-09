package at.co.sdt.herb.hw4.actors

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{ Failure, Random, Success }

object Future2 extends App {
  println("starting calculation")
  val f = Future {
    Thread.sleep(Random.nextInt(500))
    42
  }
  val x = 45

  println(s"before onComplete, f=$f")
  f.onComplete {
    case Success(v) => println(s"got the callback, meaning = $v, x=$x, f=$f")
    case Failure(ex) => println(s"got exception = $ex, x=$x, f=$f")
  }

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

  Thread.sleep(500)
}

