import akka.testkit.{ImplicitSender, TestKit}
//import org.scalatest.{BeforeAfterAll, Matchers, WordSpecLike}
import org.scalatest.{Matchers, WordSpecLike}
import akka.actor.{Actor, ActorSystem, Props}

class TestSpec extends TestKit(ActorSystem("TestSpec"))
      with ImplicitSender with WordSpecLike with Matchers {
      //with BeforeAndAfterAll {

        def afterAll {
          TestKit.shutdownActorSystem(system)
        }

        "Sum Actor " must {
          "send back sum of 2 Integers" in  {
            val sumActor = system.actorOf(Props[SumActor])
            sumActor ! (10, 12)
            //expectMsg(22)
          }
        }
}
