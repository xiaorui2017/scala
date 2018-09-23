package cn.spark.study.sql

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object GenericLoadSave {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("GenericLoadSave")

    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)
    val userDF = sqlContext.read.load("hdfs://hadoop120:9000/users.parquet")
    userDF.write.save("hdfs://hadoop120:9000/sql/TestData/nameAndColors.parquet")


  }

}












