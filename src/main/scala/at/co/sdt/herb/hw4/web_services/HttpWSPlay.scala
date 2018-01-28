package at.co.sdt.herb.hw4.web_services


object HttpWSPlay {
  def apply(): HttpWSPlay = new HttpWSPlay
}

import play.api.libs.ws.DefaultBodyReadables

import scala.concurrent.ExecutionContext.Implicits._

class HttpWSPlay extends DefaultBodyReadables {

  import play.api.libs.ws.StandaloneWSClient

  import scala.concurrent.Future

  def call(wsClient: StandaloneWSClient): Future[Unit] = {
    wsClient.url("http://www.example.com/").get().map { response ⇒
      val statusText: String = response.statusText
      val body = response.body[String]
      println(s"Got a response $statusText")
      println(body)
    }
  }
}

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object HttpWSPlayMain extends App {

  // Create Akka system for thread and streaming management
  implicit val system: ActorSystem = ActorSystem()
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  import play.api.libs.ws.ahc.StandaloneAhcWSClient

  // Create the standalone WS client
  // no argument defaults to a AhcWSClientConfig created from
  // "AhcWSClientConfigFactory.forConfig(ConfigFactory.load, this.getClass.getClassLoader)"
  val wsClient = StandaloneAhcWSClient()

  val h = HttpWSPlay()
  h.call(wsClient)
    .andThen { case _ => wsClient.close() }
    .andThen { case _ => system.terminate() }

  //why 'Failed to load class "org.slf4j.impl.StaticLoggerBinder"'? because of missing dependency
  //why 'CoordinatedShutdown from JVM shutdown failed' 10 seconds after call ended? prefer systme.terminate() over Systrm.exit(0)

}