package example3_2

import akka.actor.{Props, Actor}

class BalancingPoolActor extends Actor {
  override def receive: Receive = {
    case msg: String => println(s"I'm ${self.path.name}")
    case _ => println(s"I don't understand your message")
  }
}
