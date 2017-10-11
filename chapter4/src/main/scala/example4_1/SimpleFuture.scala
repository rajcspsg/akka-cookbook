package example4_1

import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object SimpleFuture extends App {
  val future: Future[Int] = Future(1+2).mapTo[Int]
  val sum = Await.result(future, 10 seconds)
  println(s"the sum is $sum")
}
