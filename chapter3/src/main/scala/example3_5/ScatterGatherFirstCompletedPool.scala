package example3_5

import akka.actor.Actor

class ScatterGatherFirstCompletedPoolActor extends Actor {

  override def receive: Receive = {
    case msg: String => sender ! s"I say hello back to you, I'm ${self.path.name}"
    case _ => println("I don't understand what you mean...")
  }
}
