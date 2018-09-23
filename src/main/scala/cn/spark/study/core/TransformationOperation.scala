package cn.spark.study.core

import org.apache.spark.{SparkConf, SparkContext}

object TransformationOperation {
  def main(args: Array[String]): Unit = {

    //    map()
    //    filter()

    //    flatMap()
    //    groupByKey()
    //    reduceByKey()
    //    sortByKey()
    //    join()
    cogroup()
  }


  def map() {

    val conf = new SparkConf()
      .setAppName("map")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val numbers = Array(1, 2, 3, 4, 5)
    val numberRDD = sc.parallelize(numbers, 1)
    val multipleNumberRDD = numberRDD.map { num => num * 2 }
    multipleNumberRDD.foreach { num => println(num) }
  }


  def filter(): Unit = {
    val conf = new SparkConf()
      .setAppName("filter")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val numbers = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numberRDD = sc.parallelize(numbers, 1)
    val eventNumberRDD = numberRDD.filter { num => num % 2 == 0 }
    eventNumberRDD.foreach { num => println(num) }

  }


  def flatMap(): Unit = {
    val conf = new SparkConf()
      .setAppName("flatMap")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val lineArray = Array("hello you", "hello me", "hello world")

    val lineRDD = sc.parallelize(lineArray, 1)
    val words = lineRDD.flatMap { word => word.split(" ") }
    words.foreach { word => println(word) }
  }


  def groupByKey(): Unit = {
    val conf = new SparkConf()
      .setAppName("groupByKey")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val scoreList = Array(Tuple2("class1", 80), Tuple2("class1", 65), Tuple2("class2", 75), Tuple2("class2", 90))
    val scores = sc.parallelize(scoreList, 1)
    val groupScores = scores.groupByKey()
    groupScores.foreach(score => {
      println(score._1);
      score._2.foreach(singleScore => {
        println(singleScore)
      });
      println("=============")
    })

  }

  def reduceByKey(): Unit = {
    val conf = new SparkConf()
      .setAppName("reduceByKey")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val scoreList = Array(Tuple2("class1", 80), Tuple2("class1", 65), Tuple2("class2", 75), Tuple2("class2", 90))
    val scores = sc.parallelize(scoreList, 1)
    val totalScores = scores.reduceByKey(_ + _)

    totalScores.foreach(classScore => println(classScore._1 + "===" + classScore._2))

  }

  def sortByKey(): Unit = {
    val conf = new SparkConf()
      .setAppName("sortByKey")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val scoreList = Array(Tuple2(80, "leo"), Tuple2(65, "tom"), Tuple2(75, "Jack"), Tuple2(90, "Luce"))
    val scores = sc.parallelize(scoreList, 1)
    val sortScores = scores.sortByKey(false)

    sortScores.foreach(studentScore => println(studentScore._1 + "===" + studentScore._2))

  }

  def join(): Unit = {
    val conf = new SparkConf()
      .setAppName("join")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val studentList = Array(
      Tuple2(1, "leo"),
      Tuple2(2, "tom"),
      Tuple2(3, "jack"),
      Tuple2(4, "lucy")
    )
    val scoreList = Array(
      Tuple2(1, 100),
      Tuple2(2, 56),
      Tuple2(3, 95),
      Tuple2(4, 75)
    )
    //并行化两个RDD
    val students = sc.parallelize(studentList)
    val scores = sc.parallelize(scoreList)

    val studentScore = students.join(scores)

    studentScore.foreach(studentScore => {
      println("student id:" + studentScore._1)
      println("student name :" + studentScore._2._1)
      println("student score :" + studentScore._2._2)
      println("==================")
    }
    )
  }

  def cogroup(): Unit = {
    val conf = new SparkConf()
      .setAppName("join")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val studentList = Array(
      Tuple2(1, "leo"),
      Tuple2(2, "tom"),
      Tuple2(3, "jack"),
      Tuple2(4, "lucy")
    )
    val scoreList = Array(
      Tuple2(1, 100),
      Tuple2(2, 56),
      Tuple2(3, 95),
      Tuple2(1, 65),
      Tuple2(2, 68),
      Tuple2(3, 63),
      Tuple2(4, 82),
      Tuple2(4, 75)
    )
    //并行化两个RDD
    val students = sc.parallelize(studentList)
    val scores = sc.parallelize(scoreList)

    val studentScore = students.cogroup(scores)

    studentScore.foreach(studentScore => {
      println("student id:" + studentScore._1)
      println("student name :" + studentScore._2._1)
      println("student score :" + studentScore._2._2)
      println("==================")
    }
    )
  }

}