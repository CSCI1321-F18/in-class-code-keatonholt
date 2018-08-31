package basics

object TestHitBox {
  def main(args: Array[String]): Unit = {
    val hb1 = new HitBox()
    val hb2 = new HitBox()
    println(hb1.intersects(hb2))
    println(hb1.cx)
    
    val hb3 = new HitBox()
    val hb4 = new HitBox(1.1, 1, 1, 1)
    println(hb3.intersects(hb4))
    
    val hb5 = new HitBox
    
  }
}