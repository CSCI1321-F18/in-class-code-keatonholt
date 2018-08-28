package basics

class HitBox (
  private var _cx: Double = 0.0, //center x
  private var _cy: Double = 0.0, //center y
  val width: Double = 1.0,
  val height: Double = 1.0) {
  
  def cx = _cx
  def cy = _cy
  
  def intersects(other: HitBox): Boolean = {
    val overLapX = (_cx-other._cx).abs <= 0.5*(width+other.width)
    val overLapY = (_cy-other._cy).abs <= 0.5*(height+other.height)
    if(overLapX && overLapY) true
    else false
  }
}


