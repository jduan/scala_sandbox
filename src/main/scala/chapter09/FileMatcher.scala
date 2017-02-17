package chapter09

import java.io.File

object FileMatcher {

  def filesEnding(files: Array[File], query: String): Array[File] = {
    //    filesMatching(files, (name: String) => name.endsWith(query))
    filesMatching(files, _.endsWith(query))
  }

  def filesContaining(files: Array[File], query: String): Array[File] = {
    filesMatching(files, _.contains(query))
  }

  def filesRegex(files: Array[File], query: String): Array[File] = {
    filesMatching(files, _.matches(query))
  }

  def filesMatching(files: Array[File],
                    matcher: (String) => Boolean): Array[File] = {
    for (file <- files; if matcher(file.getName)) yield file
//    filesHere.filter(file => matcher(file.getName, query))
  }
}

object Main extends App {
  val filesHere: Array[File] = (new java.io.File("src/main/scala/case_classes")).listFiles()
  println("====filesEnding====")
  println(FileMatcher.filesEnding(filesHere, ".scala").mkString("\n"))
  println("====filesRegex====")
  println(FileMatcher.filesRegex(filesHere, ".*scala").mkString("\n"))
}