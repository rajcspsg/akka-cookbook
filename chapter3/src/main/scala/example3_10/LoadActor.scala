package example3_10

import akka.actor.Actor

class LoadActor extends Actor {
  override def receive: Receive = {
    case Load => println(s"Handling Loads of Requests")
  }
}
