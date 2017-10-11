package example3_3

import akka.actor._
import akka.routing._

object RoundRobinApp extends App {
  val actorSystem = ActorSystem("RoundRobinActorSystem")
  val router = actorSystem.actorOf(
    RoundRobinPool(5).props(
      Props[RoundRobinPoolActor]
    )
  )

  for(i <- 1 to 5) {
    router ! s"Hello $i"
  }
}
