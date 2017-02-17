package chapter09

import java.io.{File, PrintWriter}

object LoanPattern {
  def withPrintWriter(file: File)(op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }
}

object Main2 extends App {
  val file = new File("date.txt")
  LoanPattern.withPrintWriter(file) { writer =>
    writer.println(new java.util.Date())
  }
}
