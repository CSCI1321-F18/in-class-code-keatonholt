package challengeProblem

import scala.collection.mutable.Buffer

object Main extends App {

  def boxes(sz: Array[Double], obj: Array[Double]): Boolean = {
    if (sz.sum > obj.sum) {
      var olst = obj.toBuffer
      var stored = olst
      for (s <- sz) {
        for (i <- 0 until olst.length) {
          if(olst(i) < s){
            stored += olst(i)
            val fills = Buffer[Buffer[Double]]()
            for(j <- 0 until olst.length if j != i){
              if((olst(i) + olst(j)) <= s){
                stored += olst(j)
              }
            }
          }
        }
      }
    }

    ???
  }
}