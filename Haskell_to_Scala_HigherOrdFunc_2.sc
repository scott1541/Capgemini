val list = List(1,2,3,4,5,6,7,8,9,10,11,12)
val listN = List(List(1,2,3), List(4,5,6), List(), List(7,8,9), List(10,11,12), List())

val inString = "CNnveRttHIsStrInG"
val inString2 = "eHeEgrLbsLOseWnORdsLdD"

//Filter function
//Greater than 3
list.filter(x => x > 3)
//Equal to 3
list.filter(x => x == 3)
//Even numbers
list.filter(x => x % 2 ==0)
//Filter empty list elements
listN.filter(x => x != List())
//Filter out upper case
inString.filter(_.isLower)
//Filter out lower case
inString2.filter(_.isUpper)


//Quicksort with Filter

def quickSortF(nums: Seq[Int]): Seq[Int] = {
  nums match{
    case nums if(nums.length <= 1) => nums
    case _ => val pivot = nums(nums.length / 2)
              Seq.concat(quickSortF(nums.filter( x => (x < pivot))),
              nums.filter(x => x == pivot),
              quickSortF(nums.filter( x => (x > pivot))))
              }
}

quickSortF(List(3,4,2,1,8,6,10,11,9))


//Find all numbers 1-100000 divisible by 3829
(1 to 100000).filter(x => x % 3829 == 0)

//Sum of odd squares below 10000
(1 to 10000).map(x => x * x).takeWhile(x => !(x % 2 == 0) || x < 10000).sum


//Collatz Sequence
def collatz(start: Double): List[Any] = {

  def collatzSeq(startS: List[Double]): List[Any] = {

    startS match {
      case _ if(startS.head == 1) => startS
      case _ if(startS.head %2 == 0) => startS:+ (startS.head / 2);  collatzSeq(startS)
      case _ if(startS.head %2 != 0) => startS:+ (startS.head * 3 + 1); collatzSeq(startS)
    }
  }

collatzSeq(List(start))
}

collatz(5)

//Map 1-100 collatz sequences
(1 to 100).flatMap(x => collatz(x))



//Folds (and reduce)

val newList = List(2,1,3,5,4,6,7,8,9,10)

newList.foldLeft(3)(_+_)

newList.foldLeft(2)(_-_)

newList.foldLeft(2)(_*_)

newList.foldRight(0)(_+_)

newList.fold(1)(_+_)

newList.reduceLeft(_+_)

newList.reduceRight(_+_)

newList.reduceRight(_*_)
