package exercise3_5

import akka.actor._

class ServiceActor extends Actor {
  override def receive: Receive = {
    case Service => println(s"I provide a special service")
  }

}
