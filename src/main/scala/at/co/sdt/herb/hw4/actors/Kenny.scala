package at.co.sdt.herb.hw4.actors

import akka.actor.{ Actor, ActorSystem, Props }

class Kenny extends Actor {
  println("Kenny constructor start")

  override def preStart(): Unit = {
    println("Kenny preStart start")
    super.preStart()
    println("Kenny preStart end")
  }

  override def postStop(): Unit = {
    println("Kenny postStop start")
    super.postStop()
    println("Kenny postStop end")
  }

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println("Kenny preRestart start")
    super.preRestart(reason, message)
    println("Kenny preRestart end")
  }

  override def postRestart(reason: Throwable): Unit = {
    println("Kenny postRestart start")
    super.postRestart(reason)
    println("Kenny postRestart end")
  }

  override def receive: Receive = {
    case ForceRestart => throw new Exception("Boom!")
    case m => println(s"Kenny received $m")
  }

  println("Kenny constructor end")
}

case object ForceRestart

object KennyDemo extends App {
  val system = ActorSystem("KennyDemo")
  val kenny = system.actorOf(Props[Kenny])

  println("sending Kenny Hello")
  kenny ! "Hello"
  Thread.sleep(2000)

  println("send Kenny ForceRestart")
  kenny ! ForceRestart
  Thread.sleep(2000)

  println("sending Kenny 2nd Hello")
  kenny ! "2nd Hello"
  Thread.sleep(2000)

  println("stopping Kenny")
  system.stop(kenny)
  Thread.sleep(2000)

  println("send Kenny ForceRestart")
  kenny ! ForceRestart
  Thread.sleep(2000)

  println("terminating actor system")
  system.terminate()
}