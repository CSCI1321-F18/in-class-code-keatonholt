package actorstuff

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef

object ThreeActorCountdown extends App {
  
  class TACActor extends Actor {
    def receive = {
      case CountDown(n, next, nextnext) =>
        if(n>=1){
          println(context.self.path.name + " saying " + n)
          next ! CountDown(n-1, nextnext, self)
        } else {
          system.terminate() //stop if count is down to 0
        }
      case m => println("Unhandled Message in TACActor " + m)
    }
  }
  
  val system = ActorSystem("ThreeActors")
  val a1 = system.actorOf(Props[TACActor], "Counter1") //or system.actorOf(Props(new TACActor), "name")
  val a2 = system.actorOf(Props[TACActor], "Counter2")
  val a3 = system.actorOf(Props[TACActor], "Counter3")
  
  a1 ! CountDown(100, a2, a3)
  
  case class CountDown(n: Int, next: ActorRef, nextnext: ActorRef)
}