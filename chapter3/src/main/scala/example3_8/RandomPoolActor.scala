package example3_8

import akka.actor.Actor

class RandomPoolActor extends Actor {
  override def receive: Receive = {
    case msg: String => println(s"I'm ${self.path.name}")
    case _ => println("unknown message")

  }
}
