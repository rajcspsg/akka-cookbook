package example3_3

import akka.actor._

class RoundRobinPoolActor extends Actor {
  override def receive: Receive = {
    case msg: String => println(s"I'm ${self.path.name}")
    case _ => println(s"I don't understand the message")
  }
}
