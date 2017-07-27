
//Currying
//A simple curried function, takes two separate arguments
def CurrFunc(a: Int)(b: Int): Int = {

  return a + b
}

//Returns function
CurrFunc(23) _

//Both return value
(CurrFunc(27) _).apply(34)

CurrFunc(34)(27)


//Apply Multiple
//Takes an input string and applies it multiple times

def ApplyTwice(text: String): String = text * 2
def ApplyThrice(text: String): String = text * 3

def ProcessText(input: String, function: String => String): Unit = {

  println(function(input))
}

ProcessText("Hello World", ApplyThrice)

ProcessText("Test", ApplyTwice)


val list1: List[Int] = List(6,3,9,1,2,5,8)
val list2: List[Int] = List(4,5,10,0,7,11,3)


//Zip with

//Takes two lists and applies function, in this case add or maximum
/*
def Add(list1: List[Int], list2: List[Int]): List[Int] = {
val list3: List[(Int, Int)]= list1.zip(list2)
println(list3)

//list3.foreach(item => println(item.reduceLeft(_+_)))

//println(list3.reduceLeft(_*_))

//list3.reduceLeft((a,b) => a + b)
//a.reduceLeft( (a,b) => a + b )
}

def Max()

def ZipWith(list1: List[Int], list2: List[Int], function: List[Int] => List[Int]): Unit = {

  println(function(list1, list2))
}

*/

//Map
//Add 3
val list = List(1,2,3,4,5,6,7,8,9,10,11,12)

list.map(x => x + 3) //res5: List[Int] = List(4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
list.map( x => x * 2)//res6: List[Int] = List(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24)