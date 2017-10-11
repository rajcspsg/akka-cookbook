package example4_3
import akka.actor.{ActorSystem, Props}
import scala.concurrent.{Await, Future}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._

object FutureInsideActorDemo extends App {
  implicit val timeout: Timeout = Timeout(10 seconds)
  val system = ActorSystem("FutureInsideActorSystem")
  val fActor = system.actorOf(Props[FutureInsideActor])
  println("The result is" + (fActor ! (10, 20)))
  val fResult = (fActor ? (10, 20)).mapTo[Int]
  println(s"${fResult}")
}
