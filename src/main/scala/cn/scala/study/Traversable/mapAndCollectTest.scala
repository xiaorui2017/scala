package scala.study.Traversable

class mapAndCollectTest {
  //map操作，一对一映射
  val scoreMap = Map("leo" -> 90, "jack" -> 80, "tom" -> 70)
  val names = List("leo", "jack", "tom")
  names.map(scoreMap(_))

  //flatMap操作,一对多映射

  val scoreMap2 = Map("leo" -> List(80, 70, 60), "jack" -> List(70, 80, 90), "tom" -> List(92, 97, 68))
  names.map(scoreMap2(_))
  names.flatMap(scoreMap2(_))

  //collect操作，结合偏函数使用

  "abc".collect { case 'a' => 1; case 'b' => 2; case 'c' => 3 }

  //foreach操作，遍历
  names.foreach(println _)

}
