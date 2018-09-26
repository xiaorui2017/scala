package scala.study.ReduceAndFold

class reduceAndFoldTest {
  //reduce操作
  List(1,2,3,4).reduceLeft(_ - _)
  // 1 - 2 - 3 - 4
  List(1,2,3,4).reduceRight(_ - _)
  //4 - 3 - 2 - 1

//  fold 操作
  List(1,2,3,4).foldLeft(10)(_ - _)
  // (((10 -1) -2) -3) -4 =0
  List(1,2,3,4).foldRight(10)(_ - _)
  //1-(2- (3-(4 - 10)))=8

}
