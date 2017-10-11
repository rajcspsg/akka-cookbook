package example5_3
import akka.actor.Actor
class CancelOperationActor extends Actor {
    var i = 10

    override def receive: Receive = {
      case "tick" =>
        println(s"Hi, do you know I do the same task again and again")
        i = i - 1
        if (i == 0) CancelSchedulerDemo.cancellable.cancel()
    }
}
