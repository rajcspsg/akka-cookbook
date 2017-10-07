package exercise3_4

import akka.actor._

object  AllForOneStrategyApp extends App {
  val system = ActorSystem("AllForOneStrategySystem")
  val supervisor = system.actorOf(Props[AllForOneStrategySupervisor], "supervisor")
  supervisor ! "Start"
}
