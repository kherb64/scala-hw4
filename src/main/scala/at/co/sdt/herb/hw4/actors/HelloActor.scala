package at.co.sdt.herb.hw4.actors

import akka.actor.{Actor, ActorSystem, Props}

class HelloActor extends Actor {
  override def receive: PartialFunction[Any, Unit] = {
    case s@"hello" => println(s"$s back at you")
    case _ => println("huh")
  }
}

object Main extends App {
  val system = ActorSystem("HelloActor")

  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")

  helloActor ! "hello"
  helloActor ! "buenos dias"

}