package adt

trait MyPriorityQueue[A] {
  def enqueue(a: A): Unit //adds something to back of the queue
  def dequeue(): A //takes off the thing that has highest priority
  def peek: A
  def isEmpty: Boolean
}