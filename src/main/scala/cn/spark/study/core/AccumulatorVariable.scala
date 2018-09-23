package cn.spark.study.core

import org.apache.spark.{SparkConf, SparkContext}

object AccumulatorVariable {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("AccumulatorVariable")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val sum = sc.accumulator(0)

    val numberArray = Array(1, 2, 3, 4, 5)
    val numbers = sc.parallelize(numberArray, 1)
    numbers.foreach(num => sum += num)
    println(sum)
  }
}
