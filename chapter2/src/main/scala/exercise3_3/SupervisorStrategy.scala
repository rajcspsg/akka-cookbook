package exercise3_3

import akka.actor.{Actor, Props}
import akka.actor.SupervisorStrategy._
import scala.concurrent.duration._
import akka.actor.SupervisorStrategy._

import akka.actor._
import akka.actor.SupervisorStrategy._
import akka.util.Timeout
import scala.concurrent.Await
import scala.concurrent.duration._
import akka.pattern.ask

class SupervisorStrategyActor extends Actor {

  override val supervisorStrategy =
      OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 minutes) {
        case _: ArithmeticException => Restart
        case _: NullPointerException => Resume
        case _: IllegalArgumentException => Stop
        case _: Exception => Escalate
      }

  val printer = context.actorOf(Props[Printer])
  val intAdder = context.actorOf(Props[IntAdder])

  override def receive: Receive = {
    case "Start" => printer ! "Hello Printer"
    printer ! 10
    intAdder ! 10
    intAdder ! 10
    intAdder ! "Hello int Adder"
  }

}
