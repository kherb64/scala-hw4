package at.co.sdt.herb.hw4.actors

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object Future1 extends App {
  // used by 'time' method
  implicit val baseTime: Long = System.currentTimeMillis

  // 2 - create a Future
  val f = Future {
    Thread.sleep(500)
    1 + 1
  }

  // 3 - this is blocking (blocking is bad)
  private val result = Await.result(f, Duration("1 second"))
  println(result)
  Thread.sleep(1000)
}

