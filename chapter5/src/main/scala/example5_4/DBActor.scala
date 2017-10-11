package example5_4
import akka.actor.Actor
class DBActor extends Actor {
  override def receive: Receive = {
    case FetchRecord(recordId) =>
      if(recordId >= 3 && recordId <= 5)
        Thread.sleep(3000)
      else
        sender ! DB.data.get(recordId)
  }
}
