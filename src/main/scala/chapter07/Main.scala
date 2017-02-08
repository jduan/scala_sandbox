package chapter07

import scala.io.Source

object Main extends App {
  val filename = if (!args.isEmpty) args(0) else "default.txt"
  println(s"filename is $filename")

  println(s"GCD of 18 and 6 is: ${gcdLoop(18, 6)}")
  println(s"GCD of 18 and 10 is: ${gcdLoop(18, 10)}")

  def gcdLoop(x: Long, y: Long): Long = {
    // while loop
    var a = x min y
    var b = x max y
    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }

    b
  }

  val iter = Source.fromFile("/tmp/1").getLines()
  while (iter.hasNext) {
    var line = ""
    // the next line gets warning from the compiler because assignment in Scala
    // always results in the unit value ()
    if ((line = iter.next()) != "") {
      println(s"line: $line")
    }
  }

  // recursion
  def gcd(x: Long, y: Long): Long =
    if (y == 0) x else gcd(y, x % y)

  println(s"GCD of 18 and 6 is: ${gcd(18, 6)}")
  println(s"GCD of 18 and 10 is: ${gcd(18, 10)}")

  def fileLines(file: java.io.File): List[String] =
    Source.fromFile(file).getLines().toList

  def grep(dir: String, pattern: String): Unit =
    for {
      file <- (new java.io.File(dir)).listFiles()
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(pattern)
    } println(s"$file: $trimmed")

  grep("/Users/jduan/github/scala_sandbox/src/main/scala/chapter07", "def.*")

  // print multiplication table
  def multiTable(n: Int): Seq[Seq[Int]] = {
    for (i <- 1 to n) yield {
      for (j <- 1 to n) yield i * j
    }
  }

  val n = 10
  val width = (n * n).toString.size
  for (s <- multiTable(10)) {
    println(s.map(i => " " * (width - i.toString.size) + i.toString).mkString(" "))
  }
}
