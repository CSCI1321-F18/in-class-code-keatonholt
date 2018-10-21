package actorstuff

import akka.actor.Actor

class ChatManager extends Actor{
  import ChatManager._
  def receive = {
    //case NewChatter(name,sock,ps,br) =>
      //for(child <- context.children) child !
      //context.actorOf(Props(new Chatter(name,sock,ps,br)), name)
    case m => println("unhandled message in Chat Manager",m)
  }
}

object ChatManager {
  //case class NewChatter(name:String
}