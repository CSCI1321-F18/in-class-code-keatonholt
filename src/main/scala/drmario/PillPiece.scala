package drmario

class PillPiece (private var _x:Int, private var _y:Int) extends Block{
  def x: Int = _x
  
  def y: Int = _y
  
  def color: MarioColor.Value = MarioColor.Red
  
  def move(dx:Int, dy:Int):Unit = {
    _x += dx
    _y += dy
  }

}