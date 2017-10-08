package example3_1

import akka.actor._
import akka.routing.SmallestMailboxPool

class SmallestMailBoxActor extends Actor {
  override def receive: Receive = {
    case msg: String => println(s"I'm ${self.path.name}")
    case _ => println(s"I don't understand the message")
  }
}
