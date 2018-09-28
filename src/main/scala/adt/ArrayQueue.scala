package adt

import scala.reflect.ClassTag

class ArrayQueue[A: ClassTag] extends MyQueue[A] {
  private var queue = new Array[A](10) //Array.fill[A](10)(null.asInstanceOf(A))
  private var front = 0
  private var back = 0
  
  def enqueue(thing: A): Unit = {
    if((back+1)%queue.length == front) {
      val tmp = new Array[A](queue.length*2)
      for(i <- 0 until queue.length-1) {
        tmp(i) = queue((front+i)%queue.length)
      }
      front = 0
      back = queue.length-1
      queue = tmp
    }
    queue(back) = thing
    back = (back+1)%queue.length
  }
  def dequeue(): A = {
    val ret = queue(front)
    front = (front+1)%queue.length
    ret
  }
  def peek: A = queue(front)
  def isEmpty: Boolean = (front == back)
}

object ArrayQueue extends App {
  
}