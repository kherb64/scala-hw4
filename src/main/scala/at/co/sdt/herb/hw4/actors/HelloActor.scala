package at.co.sdt.herb.hw4.actors

import akka.actor.{ Actor, ActorSystem, Props }

class HelloActor extends Actor {
  override def receive: PartialFunction[Any, Unit] = {
    case s @ "hello" => println(s"$s back at you")
    case _ => println("huh?")
  }
}

class HelloName(val name: String) extends Actor {
  override def receive: Receive = {
    case s @ "hello" => println(s"$s back from ${ this.name }")
    case _ => println(s"huh? from ${ this.name }")
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")

  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
  val helloFreddy = system.actorOf(Props(new HelloName("Freddy")), name = "hellofreddy")

  helloActor ! "hello"
  helloActor ! "buenos dias"
  helloFreddy ! "hello"
  helloFreddy ! "buenos dias"

  system.terminate()
}