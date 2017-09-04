package at.co.sdt.herb.hw4.actors

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, PoisonPill, Props, Terminated}

import scala.collection.mutable.ArrayBuffer

object Child {
  def props(name: String) = Props(new Child(name))
}

class Child(name: String) extends Actor with ActorLogging {
  log.info(s"Child ${this.name} constructor start")

  override def postStop(): Unit = {
    super.postStop()
    log.info(s"Child ${this.name} postStop end")
  }

  override def receive: Receive = {
    case m => log.info(s"Child ${this.name} received $m")
  }
}

object Parent {

  case object Messages {

    case class CreateChild(name: String)

    case class Child(name: String)

    case object Childrens

  }

}

class Parent extends Actor with ActorLogging {
  private var Children: ArrayBuffer[ActorRef] = ArrayBuffer()

  override def postStop(): Unit = {
    super.postStop()
    log.info(s"Parent postStop end")
  }

  override def receive: Receive = {
    case Parent.Messages.CreateChild(n) =>
      val c = context.actorOf(Child.props(n), n)
      context.watch(c)
      //answered: ask how to keep track of dynamic incoked child Actors. Yes, keep track of it manually.
      Children += c
    case Parent.Messages.Child(name) =>
      for {c <- Children
           if c.path.name.endsWith(name)} println(c)
    case Parent.Messages.Childrens => println(this.Children)
    case Terminated(c) => log.warning(s"Child $c has stopped")
    case m => log.info(s"Parent received $m")
  }

}

object ChildDemo extends App {
  val system = ActorSystem("ChildDemo")
  val parent = system.actorOf(Props[Parent], "Parent")

  println("sending parent Hello")
  parent ! "Hello"
  Thread.sleep(1000)

  println("letting parent create children Burli and Bertl")
  parent ! Parent.Messages.CreateChild("Burli")
  parent ! Parent.Messages.CreateChild("Bertl")
  Thread.sleep(1000)

  parent ! Parent.Messages.Childrens
  parent ! Parent.Messages.Child("Burli")
  parent ! Parent.Messages.Child("Burli2")

  val burli = system.actorSelection("/user/Parent/Burli")
  val bertl = system.actorSelection("/user/Parent/Bertl")
  val children = system.actorSelection("/user/Parent/*")
  // answered: ask why a message can be sent to an ActorSelection not only to an ActorRef. Mehr wir Postwurfsendung
  burli ! "Hello Burli"
  burli ! PoisonPill
  bertl ! "Hello Bertl"
  system.actorSelection("/user/Parent/Bertl2") ! "Hello Bertl2"
  children ! "Hello children"
  Thread.sleep(1000)

  println("terminating actor system")
  system.terminate()
}