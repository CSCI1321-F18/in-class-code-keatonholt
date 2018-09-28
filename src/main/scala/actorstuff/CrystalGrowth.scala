package actorstuff

import akka.actor.ActorSystem
import scalafx.application.JFXApp
import akka.actor.Props
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.image.WritableImage
import scalafx.scene.image.ImageView

object CrystalGrowth extends JFXApp {
  val system = ActorSystem("Crystals")
  val a1 = system.actorOf(Props[ParticleManager], "Counter1")
  
  stage = new PrimaryStage {
    title = "Crystals"
    scene = new Scene(1000,1000) {
      val img = new WritableImage(1000,1000)
      content = new ImageView(img)
    }
  }
}