package exercise3_5

import akka.actor.{Actor, ActorSystem, Props}
object DetahWatchApp extends App {
  val actorSystem = ActorSystem("DeathWatchSuprevision")
  val deathWatchActor = actorSystem.actorOf(Props[DeathWatchActor])
  deathWatchActor ! Service
  deathWatchActor ! Service
  Thread.sleep(1000L)
  deathWatchActor ! Kill
  deathWatchActor ! Service
}
