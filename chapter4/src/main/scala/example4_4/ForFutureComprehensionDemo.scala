package example4_4

import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureForComprehensionDemo extends App {
  val futureA: Future[Int] = Future(20 + 30)
  val futureB: Future[Int] = Future(30 + 30)

  val finalFuture: Future[Int] = for {
    a <- futureA
    b <- futureB
  } yield a + b

  println("The future result is "+ Await.result(finalFuture, 10 seconds))
}
