package example3_6
import akka.actor.{Actor, ActorSystem, Props}
import akka.util.Timeout
import akka.pattern.ask
import akka.routing.TailChoppingPool
import scala.concurrent.Await
import scala.concurrent.duration._

object TailChoppingPoolActorDemo extends App {
  implicit val  timeout: Timeout = Timeout(10 seconds)
  val system = ActorSystem("TailChoppingPoolActorSystem")
  val router = system.actorOf(
    TailChoppingPool(5, within = 10 seconds, interval = 20 millis).props(
      Props[TailChoppingPoolActor]
    )
  )

  println(Await.result((router ? "hello").mapTo[String], 10 seconds))
}
