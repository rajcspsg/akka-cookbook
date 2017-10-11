package example5_5
import akka.actor.{Actor, ActorLogging}

class LoggingActor extends Actor with ActorLogging {
  override def receive: Receive = {
    case(a: Int, b: Int) =>  {
      log.info(s"sum of $a and $b is ${a+b}")
    }
    case msg =>
      log.warning(s"i don't know what are you're talking about, $msg?")
  }
}
