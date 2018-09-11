package drmario

class Grid {
  private var entities: List[Entity] = {
    (for(i <- 0 until 8; j <- 4 until 16; if math.random() < 0.3) yield{
      new Virus(MarioColor.Blue, i, j) 
    }).toList
  }
  
  private var currentPill: Pill = ???
  private var nextPill: Pill = ???
  
  def blocks(): List[Block] = {
    currentPill.blocks ++ entities.flatMap(_.blocks) //.flatten //takes a 2d list and makes it 1d
  }
  
  def currentPieceFalls(): Unit = {
    currentPill.move(0,1)
  }
}