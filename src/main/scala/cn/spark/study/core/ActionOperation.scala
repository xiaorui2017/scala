package cn.spark.study.core

import org.apache.spark.{SparkConf, SparkContext}

object ActionOperation {

  def main(args: Array[String]): Unit = {

    //    reduce()
    //    collect()

    //    count()
    //    take()
    countByKey()
  }

  def reduce(): Unit = {
    val conf = new SparkConf()
      .setAppName("reduce")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val numberArray = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numbers = sc.parallelize(numberArray, 1)
    val sum = numbers.reduce(_ + _)

    println(sum)
  }

  def collect(): Unit = {
    val conf = new SparkConf()
      .setAppName("collect")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val numberArray = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numbers = sc.parallelize(numberArray, 1)
    val doubleNumbers = numbers.map(num => num * 2)

    val doubleNumberArray = doubleNumbers.collect()

    for (num <- doubleNumberArray) println(num)

  }

  def count(): Unit = {
    val conf = new SparkConf()
      .setAppName("count")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val numberArray = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numbers = sc.parallelize(numberArray, 1)
    val count = numbers.count()
    println(count)
  }

  def take(): Unit = {
    val conf = new SparkConf()
      .setAppName("take")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val numberArray = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numbers = sc.parallelize(numberArray, 1)
    val count = numbers.take(3)
    for (num <- count) println(num)
  }

  def saveAsTextFile(): Unit = {
    val conf = new SparkConf()
      .setAppName("collect")

    val sc = new SparkContext(conf)

    val numberArray = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numbers = sc.parallelize(numberArray, 1)
    val doubleNumbers = numbers.map(num => num * 2)

    doubleNumbers.saveAsTextFile("hdfs://hadoop120:9000/double_number")

  }

  def countByKey(): Unit = {
    val conf = new SparkConf()
      .setAppName("countByKey")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val studentsList = Array(Tuple2("class1", "leo"), Tuple2("class2", "lucy"), Tuple2("class1", "jack"), Tuple2("class2", "tom"), Tuple2("class2", "marry"))
    val students = sc.parallelize(studentsList, 1)
    val studentCounts = students.countByKey()

    println(studentCounts)
  }

}
