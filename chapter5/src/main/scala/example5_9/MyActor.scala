package example5_9

import akka.actor.Actor

class MyActor extends  Actor {

  override def receive(): Receive = {
    case msg: String => println(msg)
  }


}
