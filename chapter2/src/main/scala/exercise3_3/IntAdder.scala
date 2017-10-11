package exercise3_3
import akka.actor.Actor

class IntAdder extends Actor {
  var x = 0

  override def receive: Receive = {
    case msg: Int =>
      x = x + msg
      println(s"IntAdder: sum is $x")
    case msg: String =>
      throw new IllegalArgumentException
  }

  override def postStop = {
    println(s"IntAdder: I'm getting stopped because I got String message")
  }
}
