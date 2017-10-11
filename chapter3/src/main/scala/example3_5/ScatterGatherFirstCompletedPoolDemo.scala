package example3_5

import akka.actor.{Actor, ActorSystem, Props}
import akka.routing.ScatterGatherFirstCompletedPool
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.{Await, duration}
import duration._

object ScatterGatherFirstCompletedPoolDemo extends App {

  implicit val timeout: Timeout = Timeout(10 seconds)

  val actorSystem = ActorSystem("ScatterGatherFirstCompletedPoolActorSystem")
  val router = actorSystem.actorOf(
    ScatterGatherFirstCompletedPool(5, within = 10 seconds).props(
      Props[ScatterGatherFirstCompletedPoolActor]

    )
  )

  println(Await.result((router ? "hello").mapTo[String], 10 seconds))

}
