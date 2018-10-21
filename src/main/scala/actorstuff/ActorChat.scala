package actorstuff

import akka.actor.ActorSystem
import akka.actor.Props
import java.net.ServerSocket
import java.io.PrintStream
import java.io.BufferedReader
import java.io.InputStreamReader

object ActorChat extends App {
  val system = ActorSystem("Chat")
  val chatManager = system.actorOf(Props[ChatManager])
  
  val ss = new ServerSocket(4040)
  while(true) {
    val sock = ss.accept()
//    Future{
//      val ps = new PrintStream(sock.getOutputStream) //this way its lines not bytes
//      val br = new BufferedReader(new InputStreamReader(sock.getInputStream))
//      ps.println("What is your name? ")
//      val name br.readLine()
//      chatManager ! chatManager.NewChatter(name, sock, ps, br)
//    }
  }
  
}