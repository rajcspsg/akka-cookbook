import akka.actor.{Actor, ActorSystem}
//import
class SummingActor extends Actor {
  var sum = 0

  override def receive: Receive = {
    case x: Int =>
      sum = sum + x
      println(s"My state as sum is $sum")
    case _ =>
      println(s"I don't know what you are talking about\n")
  }
}
