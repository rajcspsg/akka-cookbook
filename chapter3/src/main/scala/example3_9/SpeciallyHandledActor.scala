package example3_9

import akka.actor.Actor

class SpeciallyHandledActor extends Actor {
  override def receive: Receive = {
    case Handle => println(s"${self.path.name} says hello")
  }
}
