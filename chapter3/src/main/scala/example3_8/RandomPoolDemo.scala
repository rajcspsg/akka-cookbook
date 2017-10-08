package example3_8
import akka.actor.{ActorSystem, Props}
import akka.routing.RandomPool

object RandomPoolDemo extends App {
  val system = ActorSystem("RandomPoolActorSystem")
  val router = system.actorOf(RandomPool(5).props(
    Props[RandomPoolActor]
  ))
  for(i <- 1 to 5) {
    router ! s"Hello $i"
  }
}
