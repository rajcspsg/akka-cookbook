package example5_4

import akka.actor.{ActorSystem, Props}
import akka.util.Timeout
import scala.concurrent.duration._
import akka.pattern.{ask, CircuitBreaker}

object CircuitBreakerApp extends App {
  val system = ActorSystem("circuitBreaker")
  implicit val ec = system.dispatcher
  implicit val timeout = Timeout(10 seconds)

  val breaker = CircuitBreaker(system.scheduler,
                maxFailures = 3,
                callTimeout = 1 seconds,
                resetTimeout = 2 seconds).
                onOpen(println("====Stae is Open====")).
                onClose(println("====Stae is Closed==="))
  val db = system.actorOf(Props[DBActor], "DBActor")

  (1 to 10).map(recordId => {
      Thread.sleep(3000)
      val askFuture = breaker.withCircuitBreaker(db ? FetchRecord(recordId))
      askFuture.map(record => println(s"record is $record and recordId $recordId")).recover({
        case fail => "Failed with: " + fail.toString
      }).foreach(x => println(x))
    }
  )
}
