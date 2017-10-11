package example3_7

import akka.actor.Actor

class Cache extends Actor {
  var cache = Map.empty[String, String]

  override def receive: Receive = {
    case Entry(key, value) =>
      println(s"${self.path.name} is adding key $key")
      cache += (key -> value)

    case Get(key)   =>
      println(s"${self.path.name} fetching key $key")
      sender ! cache.get(key)

    case Evict(key) =>
      println(s"${self.path.name} removing key $key")
      cache -= key
  }
}
