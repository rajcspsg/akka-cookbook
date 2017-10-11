package exercise3_2

import akka.actor._
import scala.concurrent.Await
import scala.concurrent.duration._
import akka.util.Timeout
import akka.pattern.ask

object ActorLifeCycle1 extends App {
  implicit val timeout = Timeout(2 seconds)

  val actorSystem = ActorSystem("Suprevision")

  val supervisor  = actorSystem.actorOf(Props[Supervisor], "supervisior")

  val childFuture = supervisor ? (Props(new LifeCycleActor), "LifeCycleActor")

  val child = Await.result(childFuture.mapTo[ActorRef], 2 seconds)

  child ! Error
  Thread.sleep(1000)

  supervisor ! StopActor(child)

}
