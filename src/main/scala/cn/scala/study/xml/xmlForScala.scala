package scala.study.xml

class xmlForScala {
  //scala代码插入xml
val books =Array("book1","book2")
 val booksXml = <books><book>{books(0)}</book><book>{books(1)}</book></books>

  booksXml.label
  booksXml.child

  //通过xml动态生成scala代码

}
