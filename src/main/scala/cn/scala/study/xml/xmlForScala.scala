package scala.study.xml

class xmlForScala {
  //将scala代码插入到xml
  val books = Array("book1", "book2")
  val booksXml = <books>
    <book>
      {books(0)}
    </book> <book>
      {books(1)}
    </book>
  </books>

  booksXml.label
  booksXml.child


  <books>
    {for (book <- books) yield <book>
    {book}
  </book>}
  </books>

    //在xml属性中嵌入scala代码
    <book id="{books(0)}">
      {books(0)}
    </book>

  val bookIds = Map("book1" -> 1, "book2" -> 2)
  <books>
    {for ((name, id) <- bookIds) yield <book id={id}>
    {name}
  </book>}
  </books>
}
