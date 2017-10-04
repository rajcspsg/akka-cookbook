import akka.actor.ActorSystem

object HelloActorSystem extends App {

  val actorSystem = ActorSystem("HelloAkka")
  print(s"$actorSystem")

}
