package adt

import scala.collection.mutable.Buffer

class DLLBuffer[A] extends Buffer[A] {
  import DLLBuffer._
  private var end: Node[A] = new Node(null, null.asInstanceOf[A], null)
  end.prev = end
  end.next = end
  private var sz = 0

  def +=(elem: A) = {
    val n = new Node[A](end.prev, elem, end)
    end.prev.next = n
    end.prev = n
    sz += 1
    this
  }

  def +=:(elem: A) = {
    val n = new Node[A](end, elem, end.next)
    end.next.prev = n
    end.next = n
    sz += 1
    this
  }

  def apply(n: Int): A = {
    require(n < length && n >= 0)
    var rover = end.next
    for (i <- 1 until n) rover = rover.next
    rover.next.data
  }
  
  def clear(): Unit = {
    end.next = end
    end.prev = end
    sz = 0
  }
  
  def insertAll(n: Int, elems: Traversable[A]): Unit = { //need to fix this one
    require(n < length && n >= 0)
    var rover = end.next
    for(i <- 0 until n) rover = rover.next
    for(e <- elems) {
      val n = new Node(rover.prev, e, rover)
      rover.prev.next = n
      rover.prev = n
      sz+=1
    }
  }

  def length: Int = sz

  def remove(n: Int): A = {
    require(n < length && n >= 0)
    sz -= 1
    var rover = end.next
    for (i <- 0 until n) rover = rover.next
    val ret = rover.data
    rover.next.prev = rover.prev
    rover.prev.next = rover.next
    ret
  }
  
  def update(n: Int, newElem: A): Unit = {
    require(n < length && n >= 0)
    var rover = end.next
    for (i <- 1 until n) rover = rover.next
    rover.next.data = newElem
  }

  // Members declared in scala.collection.IterableLike
  def iterator: Iterator[A] = new Iterator[A] {
    private var rover = end.next
    def hasNext: Boolean = rover != end
    def next(): A = {
      val ret = rover.data
      rover = rover.next
      ret
    }
  }
}

object DLLBuffer {
  private class Node[A](var prev: Node[A], var data: A, var next: Node[A])
}