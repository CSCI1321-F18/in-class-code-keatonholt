package drmario

class Virus(
    val color: MarioColor.Value,
    val x: Int,
    val y: Int
    ) extends Block with Entity{
  
  def isSupported(): Boolean = true
  
  def blocks: List[Block] = List(this)
}