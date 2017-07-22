//Scala number translator....   translates to long scale and short scale output
//The foundation for this code was based upon an example found elsewhere

//This implementation is limited in that the maximum number is hard-coded, so billion/milliard is the max value it can output

object Main extends App {

  println("Enter a number: ")
  val input = scala.io.StdIn.readLine()
  println(input)
  val number = input.toLong

  val shortScale = output(number).replaceAll("billion", "trillion").replaceAll("milliard", "billion")
  println("Long Scale: " + output(number))
  println("Short Scale: " + shortScale)

  def output(num: Long): String = {

    num match {
      case num if(num < 0) => s"negative ${output(-num)}"
      case num if(num >= 1000000000000L) => s"${output(num / 1000000000000L)} billion ${output(num / 1000000000000L)}"
      case num if(num >= 1000000000) => s"${output(num / 1000000000)} milliard ${output(num % 1000000000)}"
      case num if(num >= 1000000) => s"${output(num / 1000000)} million ${output(num % 1000000)}"
      case num if(num >= 1000) => s"${output(num / 1000)} thousand ${output(num % 1000)}"
      case num if(num >= 100) =>  s"${output(num / 100)} hundred ${output(num % 100)}"
      case num if(num >= 20) => (num / 10) match {
                               case 2 => s"twenty ${output(num % 10)}"
                               case 3 => s"thirty ${output(num % 10)}"
                               case 5 => s"fifty ${output(num % 10)}"
                               case n@_ => s"${output(n)}ty ${output(num % 10)}" }
      case 0 => "zero"
      case 1 => "one"
      case 2 =>  "two"
      case 3 => "three"
      case 4 => "four"
      case 5 => "five"
      case 6 =>  "six"
      case 7 => "seven"
      case 8 => "eight"
      case 9 => "nine"
      case 10 => "ten"
      case 11 => "eleven"
      case 12 => "twelve"
      case 13 => "thirteen"
      case 15 => "fifteen"
      case n@_ => s"${output(n-10)}teen"
    }
  }
}