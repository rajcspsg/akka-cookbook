package exercise3_3

import akka.actor.{ActorSystem, Props}
object SupervisorStrategyApp extends App {
  val actorSystem = ActorSystem("Supervision")
  actorSystem.actorOf(Props[SupervisorStrategyActor]) ! "Start"
}
