import akka.actor.{Actor}

class SumActor extends Actor {
  override def receive: Receive = {
    case(a: Int, b: Int) => a + b
  }
}
