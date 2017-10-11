package example3_1

import akka.actor._
import akka.routing.SmallestMailboxPool

object SmallestMailboxApp extends App {
  val actorSystem = ActorSystem("SmallestMailboxActorSystem")
  val router = actorSystem.actorOf(
    SmallestMailboxPool(5).props(
      Props[SmallestMailBoxActor]
    )
  )

  for(i <- 1 to 5) {
    router ! s"Hello $i"
  }
}
