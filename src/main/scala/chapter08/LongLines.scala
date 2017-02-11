package chapter08

import scala.io.Source

object LongLines {
  def processFile(filename: String, width: Int): Unit = {
    // local functions can access things in their closures
    def processLine(line: String): Unit = {
      if (line.length > width)
        println(s"$filename: ${line.trim}")
    }
    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(line)
  }

  def processFile2(filename: String, width: Int): Unit = {
    def isLongLine(line: String): Boolean = line.length > width

    val source = Source.fromFile(filename)
    val longLines = source.getLines().filter(isLongLine)
    println(longLines.mkString("\n"))
  }
}

object FindLongLines extends App {
  val width = args(0).toInt
  for (arg <- args.drop(1)) {
//    LongLines.processFile(arg, width)
    LongLines.processFile2(arg, width)
  }
}
