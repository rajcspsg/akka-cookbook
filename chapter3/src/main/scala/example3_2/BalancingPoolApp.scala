package example3_2

import akka.actor._
import akka.routing._

object BalancingPoolApp extends App {
  val actorSystem = ActorSystem("BalancingPoolSystem")

  val router = actorSystem.actorOf(
    BalancingPool(5).props(
      Props[BalancingPoolActor]
    )
  )

  for(i <- 1  to 5) {
    router ! s"Hello $i"
  }
}
