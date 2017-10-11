package exercise3_2

import akka.actor._

case object Error
case class StopActor(actorRef: ActorRef)
