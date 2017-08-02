//16 Drop every nth element
def drop[T](n: Int, lst: List[T]): List[T] = {
  lst match {
    case Nil => Nil
    case head :: tail if(lst.length % n == 0) => drop(n, tail)
    case head :: tail => head :: drop(n, tail)
  }
}

drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))


//17 Split a list into two parts
//Uses inbuilt splitAt function...
//Could be done recursively, but little point if splitAt works

def split[T](n: Int, lst: List[T]): (List[T], List[T]) = {
lst.splitAt(n)
}
split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))


//18 Slice
//Again, uses inbuilt function

def slice[T](n: Int, m: Int, lst: List[T]): List[T] = {
  lst.slice(n, m)
}

slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))


//19 Rotate a list N places to left
//Splits list at n and swaps front and rear
//If number is neg, add length of array to it

def rotate[T](n: Int, lst: List[T]): List[T] = {
  n match {
    case n if(n > 0) => val (front, rear) = lst.splitAt(n)
                   rear ::: front
    case n if(n < 0) => val (front, rear) = lst.splitAt(n + lst.length)
                   rear ::: front
    case _ => lst
  }
}

rotate(-3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))


//20 Remove kth element from list
//Takes nth element from list, takeRight gets remaining list
//nth element is added to tuple

def removeAt[T](n: Int, lst: List[T]): (List[T],T) = {
  (lst.take(n):::lst.takeRight(lst.length - n), lst(n))
}
removeAt(1, List('a, 'b, 'c, 'd))


//21 Insert element at given position
//Splits list into front and back at insert position
//Joints them again about inserted element

def insertAt[T](ins: T, n: Int, lst: List[T]): List[T] = {
  val (front, rear) = lst.splitAt(n)
  front ::: List(ins) ::: rear
}

insertAt('new, 1, List('a, 'b, 'c, 'd))


//22 Create list containing all ints within range

def range(a: Int, b: Int): List[Int] = {
  (a to b).toList
}

range(4, 9)


//23 Extract a number of random elements
//Shuffle list with random function, take slice

def randomSelect[T](n: Int, lst: List[T]): List[T] = {
  scala.util.Random.shuffle(lst).slice(0,n)
}
randomSelect(4, List('a, 'b, 'c, 'd, 'f, 'g, 'h))


//24 Draw n random numbers from set
//Create list 0 - m, shuffle, take slice of size n

def lotto(n: Int, m: Int): List[Int] = {
  scala.util.Random.shuffle(1 to m).toList.slice(0, n)
}
lotto(6, 49)


//25 Generate random permutation of list elements
//Inbuilt random shuffle function

def randomPermute[T](lst: List[T]): List[T] = {
  scala.util.Random.shuffle(lst)
}

randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))


//26 Generate combinations of distinct objects from list
//Based from online example

def combinations[A](n: Int, lst: List[A]): List[List[A]] =
n match {
  case n if(n == 0) => List(Nil)
  case _ => mapSublists(lst) { x =>
    combinations(n - 1, x.tail) map {x.head :: _ }
  }
}

def mapSublists[A, T](lst: List[A])(f: (List[A]) => List[T]): List[T] =
  lst match {
    case Nil => Nil
    case sublist@( _ :: tail) => f(sublist) ::: mapSublists(tail)(f)
  }

combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))


//27  Group elements of a set into disjoint subsets
//Uses previous combinations function
/*
def group3[T](lst: List[T]): List[List[List[T]]] =
  for {
    a <- combinations(2, lst)
    b = lst -- a
    c <- combinations(3, b)
  } yield List(a, c, b -- c)

group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
*/   //Not working yet