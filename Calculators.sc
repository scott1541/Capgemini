//Simple Calculator

def calculator(num: Seq[Int]) : String = {

  val multiply = num.map(item => s"$item * ${num.head} = ${item * num.head}  ").mkString( "\n")
  val divide = num.map(item => s"$item ÷ ${num.head} = ${item / num.head}  ").mkString( "\n")
  val add = num.map(item => s"$item + ${num.head} = ${item + num.head} ").mkString("\n")
  val subtract = num.map(item => s"$item - ${num.head} = ${item - num.head} ").mkString("\n")

  s"\nInput: ${num.mkString(" ")} \n\n$multiply \n$divide \n$add \n$subtract"
}

calculator(2,4,6,8)


//Calculate Prime Numbers

def calculatePrimes(end: Int): Seq[Int] = {

  val odds = Stream.from(3, 2).takeWhile(_ <= Math.sqrt(end).toInt)
  val composites = odds.flatMap(i => Stream.from(i * i, 2 * i).takeWhile(_ <= end))

  Stream.from(3, 2).takeWhile(_ <= end).diff(composites).toList
}

calculatePrimes(2000000)

