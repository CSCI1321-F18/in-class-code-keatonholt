package adt

import scala.collection.mutable.Buffer

class SLLBuffer[A] extends Buffer[A] {
  import SLLBuffer._
  private var hd: Node[A] = null
  private var sz = 0

  def +=(elem: A) = {
    if (head == null) {
      hd = new Node[A](elem, null)
    } else {
      var rover = hd
      for (i <- 1 until sz) rover = rover.pointer
      rover.pointer.pointer = new Node[A](elem, null)
    }
    this
  }

  def +=:(elem: A) = {
    hd = new Node[A](elem, hd)
    sz += 1
    this
  }

  def apply(n: Int): A = {
    require(n < length && n >= 0)
    var rover = hd
    for (i <- 1 until n) rover = rover.pointer
    rover.pointer.value
  }
  
  def clear(): Unit = {
    hd = null
    sz = 0
  }
  
  def insertAll(n: Int, elems: Traversable[A]): Unit = ???

  def length: Int = sz

  def remove(n: Int): A = {
    require(n < length && n >= 0)
    sz -= 1
    if(n==0){
     val ret = hd.value
     hd = hd.pointer 
     ret
    }
    else{
      var rover = hd
      for (i <- 1 until n) rover = rover.pointer
      val ret = rover.value   
      rover.pointer = rover.pointer.pointer
      ret
    }
  }
  
  def update(n: Int, newElem: A): Unit = {
    require(n < length && n >= 0)
    var rover = hd
    for (i <- 1 until n) rover = rover.pointer
    rover.pointer.value = newElem
  }

  // Members declared in scala.collection.IterableLike
  def iterator: Iterator[A] = ???
}

object SLLBuffer {
  private class Node[A](var value: A, var pointer: Node[A])
}