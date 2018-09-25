package scala.study.xml

class elemTest {


/*  XML节点类型
  Node类是所有XML节点类型的父类型，两个重要的子类型是Text和Elem。
  Elem表示一个XML元素，也就是一个XML节点。scala.xml.Elem类型的label属性，返回的是标签名，child属性，返回的是子元素。
  scala.xml.NodeSeq类型，是一个元素序列，可以用for循环，直接遍历它。
  可以通过scala.xml.NodeBuffer类型，来手动创建一个节点序列*/

  val booksBuffer = new scala.xml.NodeBuffer
  booksBuffer += <book>book1</book>
  booksBuffer += <book>book2</book>
  val books: scala.xml.NodeSeq = booksBuffer

/*  xml元素的属性
  scala.xml.Elem.attributes属性，可以返回这儿xml元素的属性，是Seq[scala.xml.Node]类型的，继续调用text属性，可以拿到属性的值*/

  val book = <book id="1" price="10.0">book1</book>
  val bookId = book.attributes("id").text
//  还可以遍历属性
  for(attr <- book.attributes) println(attr)
//  还可以调用book.attributes.asAttrMap，获取一个属性Map
}
