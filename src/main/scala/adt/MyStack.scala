package adt

trait MyStack[A] {
  def push(a: A): Unit //adds something to back of the queue
  def pop(): A //takes off the thing that's been there the longest
  def peek: A
  def isEmpty: Boolean
}