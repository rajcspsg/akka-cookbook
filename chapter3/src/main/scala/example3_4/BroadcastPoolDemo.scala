package example3_4

import akka.actor.{Actor, ActorSystem, Props}
import akka.routing.BroadcastPool

object BroadcastPoolDemo extends App {
  val system = ActorSystem("BroadcastPoolActorSystem")
  val router = system.actorOf(
    BroadcastPool(5).props(
      Props[BroadcastPoolActor]
    )
  )

  router ! "hello"
}
