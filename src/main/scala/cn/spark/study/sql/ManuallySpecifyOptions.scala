package cn.spark.study.sql

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object ManuallySpecifyOptions {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("ManuallySpecifyOptions")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val peopleDF = sqlContext.read.format("json").load("hdfs://hadoop120/people.json")
    peopleDF.select("name").write.format("parquet").save("hdfs://hadoop120:9000/peopleName_scala")


  }
}











