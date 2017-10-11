package example4_7

import akka.util.Timeout
import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object ReducingFutures extends App {
  implicit val timeout: Timeout = Timeout(10 seconds)
  val listOfFutures = (1 to 10).map(Future(_))
  val finalFuture = Future.reduce(listOfFutures) (_ + _)
  println(s"sum to 1 to 10 is ${Await.result(finalFuture, 10 seconds)}")
}
