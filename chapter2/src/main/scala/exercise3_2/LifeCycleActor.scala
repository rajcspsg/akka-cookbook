package exercise3_2

import scala.concurrent.duration._
import akka.actor._

class LifeCycleActor extends Actor {

  var sum = 1

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println(s"sum during preRestart is $sum")
  }

  override def  preStart() : Unit = {
    println(s"sum in preStart is $sum")
  }

  def receive: Receive = {
    case Error => throw new ArithmeticException()
    case _ => println("default Msg")
  }

  override def postStop(): Unit = {
    println(s"sum in poststop is ${sum * 3}")
  }

  override def postRestart(reason: Throwable): Unit = {
    println(s"sum in postRestart is $sum")
  }
}
