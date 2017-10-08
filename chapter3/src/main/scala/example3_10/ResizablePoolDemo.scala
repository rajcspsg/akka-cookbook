package example3_10

import akka.actor.{Actor, ActorSystem, Props}
import akka.routing.{RoundRobinPool, DefaultResizer}

object ResizableActorPoolDemo extends App {
  val system  = ActorSystem("ResizablePool")
  val resizer = DefaultResizer(lowerBound = 2, upperBound = 15)
  val router  = system.actorOf(RoundRobinPool(5, Some(resizer)).props(
    Props[LoadActor]
  ))
}
