package example5_2

import akka.actor.{Actor, ActorSystem, Props}

class RandomIntActor extends Actor {
    val r = scala.util.Random

    override def receive: Receive = {
      case "tick" =>
        val randomInta = r.nextInt(10)
        val randomIntb = r.nextInt(10)
        println(s"sum of $randomInta anf $randomIntb is ${randomInta + randomIntb}")
    }
}
