package person.rulo.scala.basic.c03_class

object s12_AbstractTypeMembers {

  def main(args: Array[String]): Unit = {
    // 特质和抽象类可以包含一个抽象类型成员，意味着实际类型可由具体实现来确定
    trait Buffer {
      type T
      val element: T
    }
    // 通过抽象类来扩展这个特质后，就可以添加一个类型上边界来让抽象类型T变得更加具体
    // 这里限定了缓冲区中存储的元素只能是序列
    abstract class SeqBuffer extends Buffer {
      type U
      type T <: Seq[U]
      def length: Int = element.length
    }
    // 含有抽象类型成员的特质或类（classes）经常和匿名类的初始化一起使用
    abstract class IntSeqBuffer extends SeqBuffer {
      type U = Int
    }
    // 使用匿名类实现方式
    def newIntListBuf(elem1: Int, elem2: Int): IntSeqBuffer =
      new IntSeqBuffer {
        override type T = List[U]
        override val element: T = List(elem1, elem2)
      }

    val buf = newIntListBuf(7, 8)
    println("length = " + buf.length)
    println("content = " + buf.element)
    // 把抽象类型成员转成类的类型参数，也是可行的
    // 如下是只用类的类型参数的实现
    abstract class Buffer2[+T] {
      val element: T
    }
    abstract class SeqBuffer2[U, +T <: Seq[U]] extends Buffer2[T] {
      def length: Int = element.length
    }
    def newIntListBuf2(e1: Int, e2: Int): SeqBuffer2[Int, Seq[Int]] =
      new SeqBuffer2[Int, List[Int]] {
        override val element: List[Int] = {
          List(e1, e2)
        }
      }
    val buf2 = newIntListBuf2(7, 8)
    println("length = " + buf2.length)
    println("content = " + buf2.element)
  }

}
