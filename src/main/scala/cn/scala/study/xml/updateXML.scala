package scala.study.xml

import scala.xml._

class updateXML {

  //修改xml元素
  //默认情况下，scala中的xml表达式是不可改变的；如果要修改xml元素的话，必须拷贝一份再修改

  var books = <books>
    <book>book1</book>
  </books>
  //添加一个子元素
  var booksCopy = books.copy(child = books.child ++ <book>book2</book>)

  val book = <book id="1">book1</book>

  //修改一个属性

  var bookCopy = book % Attribute(null, "id", "1", Null)

  var bookCopy2 = book % Attribute(null, "id", "2", Attribute(null, "price", "10.0", Null))

  //从各个方面来看，比如io、xml操作、第三方类库的支持、socket、gui界面编程、jdbc访问数据库等等，scala都比java差很多
  //spark是用scala作为主要的语言开发的（但是spark底层的源码，其实都是java）
  //类加载器、线程、反射、线程池等等这些东西，全部都是java底层，外部命令的执行（ProcessBuilder）
}
