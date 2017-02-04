import scala.io.Source

def padString(s: String, width: Int): String = {
  " " * (width - s.length) + s
}

// read file into a list
val lines = Source.fromFile(args(0)).getLines().toList

// find the max line and its width
val maxLine = lines.reduceLeft((a, b) => if (a.length > b.length) a else b)
val maxWidth = maxLine.length.toString.length

// iterate lines and print them with lengths prepended
for (line <- lines)
  println(padString(line.length.toString, maxWidth) + " | " + line)
