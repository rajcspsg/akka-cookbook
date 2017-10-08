package example3_4

import akka.actor.Actor

class BroadcastPoolActor extends Actor {
  override def receive: Receive = {
    case msg: String => println(s"I'm ${self.path.name}")
    case _ => println(s"I don't understand your message")
  }
}
