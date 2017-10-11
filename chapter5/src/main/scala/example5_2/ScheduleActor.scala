package example5_2

import akka.actor.{ActorSystem, Props}
import scala.concurrent.duration._

object  ScheduleActor extends App {
  val system = ActorSystem("ScheduleActor")
  import system.dispatcher
  val actor = system.actorOf(Props[RandomIntActor])
  system.scheduler.scheduleOnce(10 seconds, actor, "tick")
  system.scheduler.schedule(11 seconds, 2 seconds, actor, "tick")

}
