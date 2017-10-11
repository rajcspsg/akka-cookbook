package example4_2

import akka.actor.Actor

class ComputationActor extends Actor {
  override val receive: Receive = {
    case ((a: Int, b: Int)) => sender ! (a+b)
  }
}
