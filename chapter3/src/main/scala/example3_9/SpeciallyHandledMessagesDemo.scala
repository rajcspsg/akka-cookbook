package example3_9

import akka.actor.{ActorSystem, Props, PoisonPill}
import akka.routing.{RandomPool, Broadcast}

object SpeciallyHandledMessagesDemo extends App {
  val system = ActorSystem("SpecialMsgHandlerActorSystem")
  val router = system.actorOf(RandomPool(5).props(
    Props[SpeciallyHandledActor]
  ))

  router ! Broadcast(Handle)
  Thread.sleep(1000L)
  router ! Broadcast(PoisonPill)
  Thread.sleep(1000L)
  router ! Handle
}
