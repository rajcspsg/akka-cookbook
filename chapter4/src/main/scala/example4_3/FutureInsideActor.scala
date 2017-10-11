package example4_3

import akka.actor.Actor
import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

class FutureInsideActor extends Actor {
  import context.dispatcher

  override def receive: Receive = {
    case ((a: Int, b: Int)) =>
      val f = Future(a+b)
      Await.result(f, 10 seconds)
  }
}
