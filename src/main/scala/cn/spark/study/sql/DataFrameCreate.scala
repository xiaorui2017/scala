package cn.spark.study.sql

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext, sql}

object DataFrameCreate {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("DataFrameCreate")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    val df = sqlContext.
      read.json("hdfs://hadoop120:9000/students.json")

    df.show()
  }

}
