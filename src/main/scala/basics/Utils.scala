package basics

object Utils extends App {
  def findAndRemove[A](lst: List[A], pred: A => Boolean): (List[A], Option[A]) = { //gives back the modified list and OPTION of element you wanted to remove (in case you don't find it)
    def helper(rest: List[A]): (List[A], Option[A]) = rest match {
      case Nil => (Nil, None)
      case h::t => 
        if(pred(h)) (t, Some(h)) //return rest of list (tail) and give back the first element
        else{
          val (lst2, a2) = helper(t) //run it again
          (h::lst2, a2) //put the first element back in because it didn't match pred
        }
    }
    helper(lst)
  }
  
  val nums = List(6,2,8,4,10,12,14,8)
  println(findAndRemove(nums, (_:Int)%2==1)) //will remove first odd number
}


// def findAndRemove[A](lst: List[A])(pred: A => Boolean) This is what curried means