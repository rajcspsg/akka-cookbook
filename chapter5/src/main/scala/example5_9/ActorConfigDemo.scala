package example5_9

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}

object ActorConfigDemo extends App {

  val config: Config = ConfigFactory.load("akka.conf")
  val actorSystem = ActorSystem(config.getString("myactor.actorsystem"))
  val actorName = config.getString("myactor.actorname")
  val actor = actorSystem.actorOf(Props[MyActor], actorName)
  println(s"actorPath ${actor.path}")

}
