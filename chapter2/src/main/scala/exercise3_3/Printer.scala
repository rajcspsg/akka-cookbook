package exercise3_3
import akka.actor.SupervisorStrategy._
import akka.actor.{Actor, ActorSystem, Props}

class Printer extends Actor {

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println(s"Printer: I'm restarting because of ArithmeticException")
  }

  override def receive: Receive = {
    case msg: String => println(s"Printer $msg")
    case msg: Int =>  1/0 //println(s"")
  }
}
