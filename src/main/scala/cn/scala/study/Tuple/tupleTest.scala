package cn.scala.study.Tuple

object tupleTest {
  //Tuple拉链操作指的就是Zip操作
  //Zip操作，是Array类的方法，用于将两个Array，合并为一个Array
  //比如Array（v1）和Array(v2)，使用Zip操作合并后的格式为Array（（v1,v2））
  //合并后的Array的元素类型为Tuple

  val students = Array("leo", "Jack", "Jen")
  val scores = Array(80, 100, 90)
  val studentScores = students.zip(scores)

  for ((student, score) <- studentScores) println(student + "" + score)
  //如果Array的元素类型是个Tuple，调用Array的toMap方法，可以将Array转换为MapstudentScores.toMap
  val studentScoresMap = studentScores.toMap
  studentScoresMap("leo")

}
