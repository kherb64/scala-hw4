package at.co.sdt.herb.hw4.actors

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Random, Success}

object Future3 extends App {
  println("starting calculation")
  val f: Future[Int] = Future {
    Thread.sleep(Random.nextInt(500))
    if (Random.nextInt(500) > 250) throw new Exception("Yikes!") else 42
  }

  f.onComplete {
    case Success(i) => println(s"onComplete $i")
    case Failure(ex) => println(ex)
  }

  //noinspection ScalaDeprecation
  f.onSuccess {
    case i: Int => println(s"onSuccess deprecated $i")
  }

  //noinspection ScalaDeprecation
  f.onFailure {
    case ex => println(s"onFailure deprecated $ex")
  }

  for (i <- f) println(s"for $i")
  f.foreach(i => println(s"foreach $i"))
  f.foreach(println)

  for (ex <- f.failed) println(s"for $ex")

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

