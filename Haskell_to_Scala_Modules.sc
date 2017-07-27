//Intersperse - Take a list of elements (any type) and insert another
//element in between existing elements
val numList: List[Int] = List(1,2,3,4,5,6,7,8,9,10,11,12)

def intersperse[E](in: E, lst: Seq[E]): Seq[E] = {
  (in, lst) match {
    case (_, Nil) => Nil
    case (_, Seq(in)) => Seq(in)
    case (div, head :: tail) => head +: div +: intersperse(div, tail)
  }
}
//Empty list -> return empty list
//No char but sequence -> return seq
//Char + seq -> return head + char, call again
intersperse('e', numList)


//Intercalate - Similar to above but using a list, and list of lists

val numListL: List[List[Int]] = List(List(1,2,3), List(4,5,6), List(7,8,9), List(10,11,12))
val intList: List[Int] = List(0,0,0)

def intercalate[E](in: Seq[E], lst: Seq[Seq[E]]): Seq[Seq[E]] = {
  (in, lst) match {
    case (_, Nil) => Nil
    case (_, Seq(in)) => Seq(in)
    case (div, head :: tail) => head +: div +: intercalate(div, tail)

  }
}

intercalate(intList, numListL).flatten

//Transpose -
def transpose[T](lst: List[List[T]]): List[List[T]] = {
  lst.filter(_.nonEmpty) match {
    case Nil => Nil
    case xs: List[List[T]] => xs.map {_.head} :: transpose(xs.map {_.tail})
  }
}

transpose(List(List(1, 2, 3), List(4, 5), List(6, 7, 8)))

//Concat - Flatten list and remove one level of nesting
val inList  = List(List(1, 2, 3), List(4, 5), List(6, 7, 8))
inList.flatten

//ConcatMap - Similar to above but with addition of mapping
//This function takes number of dupicates and input list as args
def concatMap(n: Int, lst: List[Int]): List[Int] = {
  lst flatMap {e => List.fill(n)(e)}
}

//And - Takes a list of values and returns true if all values are true
//Condition is set in if statement rather than taken as arg
def and[T](lst: List[T]): Boolean = {
  lst match {
    case head :: Nil if(head == 5) => true
    case head :: tail if(head == 5) => and(tail)
    case head :: tail if(head != 5) => false
  }
}
and(List(5,3,5,5,5,5))

//Or - Takes a list of values and returns true if any values are true
//again condition set in if statement, not quite ideal but works
def or[T](lst: List[T]): Boolean = {
  lst match {
    case head :: Nil if(head != 5) => false
    case head :: tail if(head == 5) => true
    case head :: tail if(head != 5) => or(tail)
  }
}
or(List(9,3,5,3,2,4))