package cn.scala.study.Map

import java.awt.Font
import java.util

object javaMapToScalaMap {

  //java Map和Scala Map的隐式转换
  import scala.collection.JavaConversions.mapAsScalaMap

  val javaScores = new util.HashMap[String, Int]()
  javaScores.put("Alice", 10)
  javaScores.put("Bob", 20)
  javaScores.put("Cindy", 5)

  val scalaScores: scala.collection.mutable.Map[String, Int] = javaScores

  import scala.collection.JavaConversions.mapAsJavaMap
  import java.awt.font.TextAttribute._

  val scalaAttrMap = Map(FAMILY -> "Serif", SIZE -> 12)
  val font = new Font(scalaAttrMap)


}
