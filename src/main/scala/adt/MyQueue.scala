package adt

trait MyQueue[A] {
  def enqueue(a: A): Unit //adds something to back of the queue
  def dequeue(): A //takes off the thing that's been there the longest
  def peek: A
  def isEmpty: Boolean
  
}