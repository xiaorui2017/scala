package cn.spark.study.core

import org.apache.spark.{SparkConf, SparkContext}

object Top3 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("Top3")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val lines = sc.textFile("C:\\Users\\Administrator\\Desktop\\top.txt", 1)
    val pairs = lines.map(line => (line.toInt, line))
    val sortedPairs = pairs.sortByKey(false)
    val sortedNumbers = sortedPairs.map(sortedPair => sortedPair._1)
    val top3Num = sortedNumbers.take(3)
    for (num <- top3Num) {
      println(num)
    }
  }

}
