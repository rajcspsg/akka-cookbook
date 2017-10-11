package example4_6

import scala.concurrent.Future
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object ParallelFuturesDemo extends App {

  def fib(n: Int): Int = {
    def fib_tail(n: Int, a: Int, b: Int):Int = n match {
      case 0 => a
      case _ => fib_tail(n-1, b, a + b)
    }
    fib_tail(n, 0, 1)
  }

  val t1 = System.currentTimeMillis
  val sum = fib(100) + fib(100) + fib(100)
  println(s"sum $sum take time in sequential computation")

  val t2 = System.currentTimeMillis

  val future1 = Future(fib(100))
  val future2 = Future(fib(100))
  val future3 = Future(fib(100))

  val future = for {
    x <- future1
    y <- future2
    z <- future3
  } yield x + y + z

  future onSuccess {
    case sum =>
      val endTime = (System.currentTimeMillis) - t2
      println(s"Time taken for parrallel computation $endTime")
  }

  Thread.sleep(5000)
}
