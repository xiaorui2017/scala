package cn.spark.study.core

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 注意事项：
  * 1、如果是针对本地文件的话，如果在Windows上本地测试，windoes上有一份文件即可，
  * 如果是在spark集群上针对Linux本地文件，那么需要将文件拷贝到所有worker节点上
  * 2、spark的textFile集群上针对目录、压缩文件以及通配符进行RDD创建。
  * 3、spark默认会为HDFS文件的每一个block创建一个partition，但是也可以通过textFile()的第二个
  * 参数手动设置分区数量，只能比block数量多，不能比block数量少。
  */

object ParallelizeCollection {
  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setAppName("ParallelizeCollection")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val numbers = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numberRDD = sc.parallelize(numbers, 5)
    val sum = numberRDD.reduce(_ + _)
    println("一到十的累加和" + sum)
  }

}
