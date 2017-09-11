package at.co.sdt.herb.hw4.actors

import akka.actor.{ Actor, ActorSystem, Props }
import DavidBanner.Msgs._

class Become {

}

object DavidBanner {

  object Msgs {

    case object ActNormal

    case object TryToFindSolution

    case object BadGuysMakeMeAngry

  }

}


class DavidBanner extends Actor {

  import context._

  def become2(a: Receive): Unit = {
    println(s"becoming ${a.getClass}")
    become(a)
  }

  def hulkState: Receive = {
    case ActNormal => become2(normalState)
  }

  def normalState: Receive = {
    case TryToFindSolution =>
    case BadGuysMakeMeAngry => become2(hulkState)
  }

  override def receive: Receive = {
    case BadGuysMakeMeAngry => become2(hulkState)
    case ActNormal => become2(normalState)
  }
}

object DavidBannerDemo extends App {
  val system = ActorSystem("DavidBanner")
  val davidBanner = system.actorOf(Props[DavidBanner], "DavidBanner")
  davidBanner ! ActNormal
  davidBanner ! TryToFindSolution
  davidBanner ! BadGuysMakeMeAngry
  Thread.sleep(1000L)
  davidBanner ! TryToFindSolution
  davidBanner ! ActNormal

  system.terminate()
}