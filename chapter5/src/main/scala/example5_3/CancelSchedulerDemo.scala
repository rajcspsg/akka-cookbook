package example5_3

import akka.actor.{ActorSystem, Props, Cancellable}
import scala.concurrent.duration._

object CancelSchedulerDemo extends App {
  val system = ActorSystem("CancelScheduler")
  import system.dispatcher
  val actor = system.actorOf(Props[CancelOperationActor])
  val cancellable: Cancellable =
     system.scheduler.schedule(0 seconds, 2 seconds, actor, "tick")
}
