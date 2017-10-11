package example3_7

import akka.actor.{Actor, ActorSystem, Props}
import akka.util.Timeout
import akka.pattern.ask
import akka.routing.ConsistentHashingPool
import akka.routing.ConsistentHashingRouter.{
  ConsistentHashMapping, ConsistentHashableEnvelope
}
import scala.concurrent.Await
import scala.concurrent.duration._

object ConsistentHashingPoolDemo extends App {
  val system = ActorSystem("ConsistentHashingPoolActorSystem")

  def hashMapping: ConsistentHashMapping = {
    case Evict(key) => key
  }

  val cache = system.actorOf(ConsistentHashingPool(10, hashMapping = hashMapping).props(
    Props[Cache]
    )
  )

  cache ! ConsistentHashableEnvelope(message = Entry("hello", "HELLO"), hashKey = "hello")

  cache ! ConsistentHashableEnvelope(message = Entry("hi", "HI"), hashKey = "hi")

  cache ! Get("hello")

  cache ! Get("hi")

  cache ! Evict("hi")
}
