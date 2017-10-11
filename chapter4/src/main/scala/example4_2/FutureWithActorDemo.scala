package example4_2
import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.Await
import scala.concurrent.Future
import scala.concurrent.duration._

object FutureWithActorDemo extends App {
  implicit val timeout: Timeout = Timeout(10 seconds)
  val system = ActorSystem("FutureWithActorSystem")
  val computationActor = system.actorOf(Props[ComputationActor])
  val future: Future[Int] = (computationActor ? (2,3)).mapTo[Int]
  val sum = Await.result(future, 10 seconds)
  println(s"sum is $sum")
}
