package example4_5

import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object FutureCallbackDemo extends App {
  val futureA: Future[Int] = Future(1 + 2).mapTo[Int]
  futureA onComplete {
    case Success(x) => println(s"The result is $x")
    case Failure(ex) => ex.printStackTrace()
  }

  println("Executed before callback")
}
