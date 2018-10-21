package challengeProblem

import scala.collection.mutable.Buffer

object Main extends App {

  def boxes(sz: Array[Double], obj: Array[Double]): Boolean = {
    var ret:Long = 0
    if (sz.sum >= obj.sum && sz.max >= obj.max) {
      var left = obj.toBuffer
      val options = fits(getSums(left), sz(0))
      println(options)
      for (i <- options) {
        if (ret != 1) {
          println("Option " + i)
          var remainder = left.clone()
          for (o <- i) remainder.remove(remainder.indexOf(o))
          ret += checkOption(0, 1, sz, remainder)
          if(ret > 0) ret = 1
          println(ret)
        }
      }
    }
    if (ret >= 1) true
    else false
  }

  def checkOption(ret: Long, start: Int, sz: Array[Double], remainder: Buffer[Double]): Long = {
    var back = ret
    if(back > 1) back = 1
    if (start == sz.length) {
      if (remainder.isEmpty) back = 1
    } else {
      val options = fits(getSums(remainder), sz(start))
      println("Options: "+options, "bin: "+sz(start), "Remainder: "+remainder)
      if (options.isEmpty) back = back
      else if (back < 1) {
        for (op <- options) {
          var rem = remainder.clone()
          for (o <- op) rem.remove(rem.indexOf(o))
          back += checkOption(back, start + 1, sz, rem)
        }
      }
    }
    println(back)
    back
  }

  def fits(sums: Buffer[Buffer[Double]], size: Double): Buffer[Buffer[Double]] = {
    var ret = Buffer[Buffer[Double]]()
    for (i <- sums) if (i.sum <= size) ret += i
    ret
  }

  def getSums(obj: Buffer[Double]): Buffer[Buffer[Double]] = {
    var ret = Buffer[Buffer[Double]]()
    for (i <- 0 until obj.length) {
      var inter1 = Buffer[Buffer[Double]]()
      inter1 += Buffer(obj(i))
      for (j <- i + 1 until obj.length) {
        var inter2 = Buffer[Buffer[Double]]()
        for (k <- 1 to inter1.length) {
          var add = inter1(inter1.length - k).clone()
          add += obj(j)
          inter2 += add
        }
        inter1.appendAll(inter2)
      }
      ret.appendAll(inter1)
    }
    ret
  }

  println(boxes(Array(7,4,9), Array(3,5,1,1,3,3)))
}