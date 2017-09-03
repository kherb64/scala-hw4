package at.co.sdt.herb.hw4.actors

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

case object PingMsg

case object PongMsg

case object StartMsg

case object StopMsg

class Ping(pong: ActorRef) extends Actor {
  var Count = 0

  def incrementAndPrint(): Unit = {
    Count += 1
    println(s"$Count. ping")
  }

  private def stop(): Unit = {
    println("Ping stops")
    context.stop(self)
  }

  override def receive: Receive = {
    case StartMsg => incrementAndPrint()
      pong ! PingMsg
    case PongMsg =>
      incrementAndPrint()
      if (Count > 99) {
        sender() ! StopMsg
        stop()
      } else {
        sender() ! PingMsg
      }
    case StopMsg =>
      pong ! StopMsg
      stop()
    case u => println(s"Ping received unexpected message $u")
  }

}

class Pong extends Actor {
  override def receive: Receive = {
    case PingMsg =>
      println(" pong")
      sender() ! PongMsg
    case StopMsg =>
      println("Pong stops")
      context.stop(self)
    case u => println(s"Pong received unexpected message $u")
  }
}

object PingPongTest extends App {
  val system = ActorSystem("PingPong")
  val pong = system.actorOf(Props[Pong], "pong")
  val ping = system.actorOf(Props(new Ping(pong)), "ping")

  ping ! StartMsg
  //ping ! StopMsg

  system.terminate()
}