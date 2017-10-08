package example3_7

import akka.routing.ConsistentHashingRouter.ConsistentHashable

case class Evict(key: String)
case class Get(key: String) extends ConsistentHashable {
  override def consistentHashKey: Any = key
}

case class Entry(key: String, value: String)
