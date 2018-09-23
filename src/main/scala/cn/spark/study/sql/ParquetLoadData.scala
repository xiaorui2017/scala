package cn.spark.study.sql

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object ParquetLoadData {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("ParquetLoadData")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)


    val usersDF = sqlContext.read.parquet("hdfs://hadoop120:9000/spark-study/user.parquet")
    usersDF.registerTempTable("users")
    val userNamesDF = sqlContext.sql("select name from users")
    userNamesDF.rdd.map(row => "Name: " + row(0)).collect().foreach(userName => println(userName))
  }

}
















