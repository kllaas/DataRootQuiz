val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

for (shift <- 1 to 26) {

  var s = "GHMABGZ VKXTMXL LNVVXLL EBDX GHG-LMHI, XGMANLBTLMBV XYYHKM"
  var site = "https://sites.google.com/datarootlabs.com/dru-w3-q1/"

  val shiftedString = s.map((c: Char) => {

    val x = alphabet.indexOf(c.toUpper)

    if (x == -1) {
      c
    }
    else {
      alphabet((x + shift) % alphabet.size)
    }
  })

  val words = shiftedString.toLowerCase.split(" ")

  for (word <- words) {
    site = site + word.charAt(0)
  }

  println(site)

}


println(s"#1 - ${/*answer #1*/}")

// #2

// your code goes here

var firstLine = "10001011101010101010000111110111011110101010101101110101010101010010000010110100101010101011011010100101011010101010101010101010101110101011000101101011110101010101010101010001010101010101101010101010101010101010101010111000001010101111010100111010101001011101010111111111101010101111111101010111110101001010101111110111101011010111111101011110101111111111111101111111111010101111101010101001111101010101010100100101010111101001010101001010101001010111110101010101010101011110101010010101001111101010100101111101010101001111111111101010111111111101001010111111110110101001111101010101111111010110100011111111111010101101011111110101010101110101010101010001110111101010101010101010101000001010110111111010101010010101011110101010000001010101000000000000101001111100000000000010010101010000001"
var secondLine = "11100101000010101000001010010000010101011000110000110101000001010100000010000000010101100000110100100010111111111111111010010001010000001000000100000101011110101000000001010100000001010100101010111001010100000000000010101010101101010010101010101111001010000000000000001010010100111000010000000010100001010101000000110000001010101000000000000101001111100000000000010010101010000001"

def addAsBinary(s1: String, s2: String): String = {
  var first = s1.length - 1
  var second = s2.length - 1

  var sb: StringBuilder = new StringBuilder
  var carry = 0

  while (first >= 0 || second >= 0) {

    var sum = carry

    if (first >= 0) {
      sum += s1.charAt(first) - '0'
      first -= 1
    }
    if (second >= 0) {
      sum += s2.charAt(second) - '0'
      second -= 1
    }
    carry = sum >> 1
    sum = sum & 1
    sb.append(if (sum == 0) '0' else '1')
  }

  if (carry > 0)
    sb.append('1')

  sb.reverse

  sb.toString()
}

val resInBinary = addAsBinary(firstLine, secondLine)

var zeros = 0
var ones = 0

for (char <- resInBinary) {
  if (char == '0') {
    zeros += 1
  } else {
    ones += 1
  }
}

println(s"#2 - ${ones - zeros}")

// #3

def isPalindrome(text: String): Boolean = {
  var i1 = 0
  var i2 = text.length - 1

  while (i2 > i1) {

    if (text(i1) != text(i2))
      return false

    i1 += 1
    i2 -= 1
  }

  true
}

var palindromesCount = 0
var currNumber = 0
var palindromesSum = 0

while (palindromesCount <= 73) {

  if (isPalindrome(currNumber.toBinaryString)) {
    palindromesCount += 1
    palindromesSum += currNumber
  }

  currNumber += 1
}
// your code goes here

println(s"#3 - $palindromesSum")

// #4

var list: List[Int] = List(-1, -1, -2, -2, 1, -5, 1, 0, 1, 14, -8, 4, 5, -11, 13, 5, 7, -10, -4, 3, -6, 8, 6, 2, -9, -1, -4, 0)
list = list.sorted

var set: util.HashSet[Int] = new util.HashSet
var count: Int = 0

var i = 0
var arr_size = list.size
while (i < arr_size - 2) {
  var l = i + 1
  var r = arr_size - 1
  while (l < r) {

    if (list(i) + list(l) + list(r) == 0) {
      var hash = list(i)- list(l)* list(r)
      count += 1
      l += 1
      r -= 1
    }
    else if (list(i) + list(l) + list(r) < 0) {
      l += 1
    }
    else if (list(i) + list(l) + list(r) > 0) {
      r -= 1
    }
  }

  i += 1
}

// your code goes here


println(s"#4 - ${}")

// #5

// your code goes here
val lines = Source.fromFile("/home/alexey/Programming/Projects/Scala/DataRootTest1/src/main/scala/task5.txt").getLines.toList

var sum: BigInt = 0
for (line <- lines) {
  sum += BigInt(line)
}

println(s"#5 - ${String.valueOf(sum).substring(0, 10)}")
