import java.util

import scala.io.Source

object Quiz {

  def run() = {

    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    for (shift <- 1 to 26) {

      val encryptedString = "GHMABGZ VKXTMXL LNVVXLL EBDX GHG-LMHI, XGMANLBTLMBV XYYHKM"
      var url = "https://sites.google.com/datarootlabs.com/dru-w3-q1/"

      val shiftedString = encryptedString.map((c: Char) => {

        val x = alphabet.indexOf(c.toUpper)

        if (x == -1)
          c
        else
          alphabet((x + shift) % alphabet.length)
      })

      val words = shiftedString.toLowerCase.split(" ")

      for (word <- words) {
        url = url + word(0)
      }

      println(s"Shifting: $shift, encr: $encryptedString, url: $url")
    }

    println(s"#1 - ${/*answer #1*/}")

    // #2

    val firstLine = "10001011101010101010000111110111011110101010101101110101010101010010000010110100101010101011011010100101011010101010101010101010101110101011000101101011110101010101010101010001010101010101101010101010101010101010101010111000001010101111010100111010101001011101010111111111101010101111111101010111110101001010101111110111101011010111111101011110101111111111111101111111111010101111101010101001111101010101010100100101010111101001010101001010101001010111110101010101010101011110101010010101001111101010100101111101010101001111111111101010111111111101001010111111110110101001111101010101111111010110100011111111111010101101011111110101010101110101010101010001110111101010101010101010101000001010110111111010101010010101011110101010000001010101000000000000101001111100000000000010010101010000001"
    val secondLine = "11100101000010101000001010010000010101011000110000110101000001010100000010000000010101100000110100100010111111111111111010010001010000001000000100000101011110101000000001010100000001010100101010111001010100000000000010101010101101010010101010101111001010000000000000001010010100111000010000000010100001010101000000110000001010101000000000000101001111100000000000010010101010000001"

    def addAsBinary(s1: String, s2: String): String = {
      var first = s1.length - 1
      var second = s2.length - 1

      var sb: StringBuilder = new StringBuilder
      var carry = 0

      while (first >= 0 || second >= 0) {

        var sum = carry

        if (first >= 0) {
          sum += s1(first) - '0'
          first -= 1
        }

        if (second >= 0) {
          sum += s2(second) - '0'
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

    resInBinary.foreach((c: Char) => {

      if (c == '0') {
        zeros += 1
      } else {
        ones += 1
      }

    })

    println(s"#2 - ${ones - zeros}")

    // #3

    def isPalindrome(text: String): Boolean = {

      for (i <- 0 until text.length) {
        if (text(i) != text(text.length - 1 - i)) return false
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

    println(s"#3 - $palindromesSum")

    // #4

    var list: List[Int] = List(-1, -1, -2, -2, 1, -5, 1, 0, 1, 14, -8, 4, 5, -11, 13, 5, 7, -10, -4, 3, -6, 8, 6, 2, -9, -1, -4, 0)
    list = list.sorted

    val set: util.HashSet[List[Int]] = new util.HashSet
    var count: Int = 0

    var i = 0
    val size = list.size

    while (i < size - 2) {

      var l = i + 1
      var r = size - 1

      while (l < r) {

        if (list(i) + list(l) + list(r) == 0) {

          val currList: List[Int] = List(list(i), list(l), list(r))

          if (!set.contains(currList)) {
            count += 1

            set.add(currList)
          }

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

    println(s"#4 - $count")

    // #5

    val lines = Source.fromFile("/home/alexey/Programming/Projects/Scala/DataRootTest1/src/main/scala/task5.txt").getLines.toList
    var sum: BigInt = 0

    for (line <- lines) {
      sum += BigInt(line)
    }

    val result5 = String.valueOf(sum).substring(0, 10)
    println(s"#5 - $result5")
  }

  def main(args: Array[String]): Unit = {
    run()
  }

}