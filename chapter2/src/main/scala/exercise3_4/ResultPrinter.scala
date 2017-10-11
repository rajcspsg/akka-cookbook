package exercise3_4

import akka.actor.{Actor, ActorSystem}
import akka.actor.SupervisorStrategy._

class ResultPrinter extends Actor {
  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println(s"Printer: I am restarting as well")
  }

  override def receive: Receive = {
    case msg => println(msg)
  }
}
