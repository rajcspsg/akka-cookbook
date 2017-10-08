package example3_6

import akka.actor.Actor

class TailChoppingPoolActor extends Actor {
  override def receive: Receive = {
    case msg: String =>

      sender ! s"Hello back to you, I'm ${self.path.name}"
    case _ => println(s"I don't understand this message")
  }
}
