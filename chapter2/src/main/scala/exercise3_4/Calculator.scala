package exercise3_4

import akka.actor.{Actor, ActorRef}

class Calculator(printer: ActorRef) extends Actor {

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
      println(s"I'm restarting because of ArithmeticException")
  }

  override def receive: Receive = {
    case Add(a,b) => printer ! s"sum is ${a+b}"
    case Sub(a,b) => printer ! s"diff is ${a-b}"
    case Div(a,b) => printer ! s"div is ${a/b}"
  }
}
