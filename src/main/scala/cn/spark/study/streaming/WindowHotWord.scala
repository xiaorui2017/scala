package cn.spark.study.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Durations, Seconds, StreamingContext}

object WindowHotWord {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("lcoal[2]")
      .setAppName("WindowHotWord")

    val ssc = new StreamingContext(conf, Seconds(5))

    val searchLogsDStream = ssc.socketTextStream("hadoop120", 9999)
    val searchWordsDStream = searchLogsDStream.map(_.split(" ")(1))
    val searchWordPairsDStream = searchWordsDStream.map(searchWord => (searchWord, 1))
    val searchWordCountsDStraem = searchWordPairsDStream.reduceByKeyAndWindow(
      (v1: Int, v2: Int) => v1 + v2,
      Durations.seconds(60),
      Durations.seconds(10)
    )
    searchWordCountsDStraem.transform(searchWordCountsRDD => {
      val countSearchWordsRDD = searchWordCountsRDD.map(tuple => (tuple._2, tuple._1))
      val sortedCountSearchWordsRDD = countSearchWordsRDD.sortByKey(false)
      val sortedSearchWordCountsRDD = sortedCountSearchWordsRDD.map(tuple => (tuple._1, tuple._2))
      val top3SearchWordCounts = sortedSearchWordCountsRDD.take(3)
      for (tuple <- top3SearchWordCounts) {
        println(tuple)
      }
      searchWordCountsRDD
    })

    ssc.start()
    ssc.awaitTermination()
  }
}