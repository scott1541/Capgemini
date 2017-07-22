//Scala Atbash Cipher

val input = "hello my name is jim".toUpperCase.toList
val cipher = ('A' to 'Z').map(e => (e, (155 - e).toChar)).toMap
val output = input.foreach(item =>
    if (item == ' ') {print(' ')}
    else {print(cipher(item))})


//Regex could probably be implemented to improve this code, doesn't handle punctuation or special chars well at the minute