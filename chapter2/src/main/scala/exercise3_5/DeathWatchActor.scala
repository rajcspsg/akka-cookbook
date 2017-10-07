package exercise3_5

import akka.actor.{Actor, Props, Terminated}

class DeathWatchActor extends Actor {
  val child = context.actorOf(Props[ServiceActor], "serviceActor")

  context.watch(child)

  override def receive: Receive = {
    case Service => child ! Service
    case Kill =>
      context.stop(child)
    case Terminated(`child`) =>   println(s"The ServiceActor is terminated and no longer available")
  }
}
