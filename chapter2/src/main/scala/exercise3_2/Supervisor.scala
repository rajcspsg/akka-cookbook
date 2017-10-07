package exercise3_2

import akka.actor._
import akka.actor.SupervisorStrategy._
import akka.util.Timeout
import scala.concurrent.Await
import scala.concurrent.duration._
import akka.pattern.ask

class Supervisor extends Actor {
  override val supervisorStrategy =
    OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 minutes) {
      case _: ArithmeticException =>
              Restart
      case t => super.supervisorStrategy.decider.applyOrElse(t, (_: Any) => Escalate)
    }

    def receive: Receive = {
      case (props: Props, name: String) =>
        sender ! context.actorOf(props, name)
      case StopActor(actorRef) => context.stop(actorRef)
    }
}
