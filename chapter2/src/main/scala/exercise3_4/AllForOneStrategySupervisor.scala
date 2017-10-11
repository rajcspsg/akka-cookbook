package exercise3_4

import akka.actor._
import akka.actor.SupervisorStrategy._
import scala.concurrent.duration._

class AllForOneStrategySupervisor extends Actor {
  override val supervisorStrategy =
    AllForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 seconds) {
      case _: ArithmeticException => Restart
      case _: NullPointerException => Resume
      case _: IllegalArgumentException => Stop
      case _: Exception => Escalate
    }

  val printer = context.actorOf(Props[ResultPrinter])
  val calculator = context.actorOf(Props(new Calculator(printer)))

  override def receive: Receive = {
    case "Start" => calculator ! Add(10, 12)
    calculator ! Sub(22, 10)
    calculator ! Div(5, 2)
    calculator ! Div(5, 0)
  }
}
