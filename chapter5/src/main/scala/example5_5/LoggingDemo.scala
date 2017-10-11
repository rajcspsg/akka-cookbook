package example5_5
import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
object LoggingDemo extends App {
  val system = ActorSystem("LoggingActorSystem")
  val actor = system.actorOf(Props[LoggingActor], "SumActor")
  actor ! (10, 12)
  actor ! "Hello!!!"
  system.terminate()
}
