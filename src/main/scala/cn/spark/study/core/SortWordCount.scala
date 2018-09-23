package cn.spark.study.core

import org.apache.spark.{SparkConf, SparkContext}

object SortWordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("SortWordCount")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val lines = sc.textFile("C:\\Users\\Administrator\\Desktop\\kafkastart.txt", 1);
    val words = lines.flatMap(line => line.split(" "))
    val pairs = words.map(word => (word, 1))
    val wordCounts = pairs.reduceByKey(_ + _)

    val countWords = wordCounts.map(wordCount => (wordCount._2, wordCount._1))
    val sortCountWords = countWords.sortByKey(false)
    val sortWordCounts = sortCountWords.map(sortCountWords => (sortCountWords._2, sortCountWords._1))
    sortWordCounts.foreach(sortWordCounts => println(sortWordCounts._1 + " appears " + sortWordCounts._2 + " times "))

  }
}
