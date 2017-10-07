import akka.actor.{Props, Actor, ActorSystem}

object BehaviorAndStateApp extends App {
  val actorSystem = ActorSystem("HelloAkka")
  val actor = actorSystem.actorOf(Props[SummingActor])
  println(s"$actorSystem")
  println(s"${actor.path}")
  //actorSystem.shutdown
  val summingActor = actorSystem.actorOf(Props[SummingActor], "SummingActor")
  println(s"${summingActor.path}")
  
}
