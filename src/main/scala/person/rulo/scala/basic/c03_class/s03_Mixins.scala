package person.rulo.scala.basic.c03_class

object s03_Mixins {

  def main(args: Array[String]): Unit = {
    /** 在类中混入特质来实现多重继承 */
    abstract class A {
      val message: String
    }
    class B extends A {
      override val message: String = "I am an instance of class B"
    }
    trait C extends A {
      def loudMessage: String = message.toUpperCase()
    }
    class D extends B with C

    val d = new D
    println(d.message)
    println(d.loudMessage)
    /** 通过混入特质来实现一个迭代器 */
    // 定义一个抽象类，包含一个抽象类型T和标准迭代器方法
    abstract class AbsIterator {
      type T
      def hasNext: Boolean
      def next(): T
    }
    // 实现一个具体的类，所有抽象成员T、hasNext、next都会被实现
    class StringIterator(s: String) extends AbsIterator {
      override type T = Char
      private var i = 0
      override def hasNext: Boolean = i < s.length
      override def next(): Char = {
        val c = s.charAt(i)
        i += 1
        c
      }
    }
    // 定义一个特质也继承自抽象类，特质可以不必实现抽象成员
    trait RichIterator extends AbsIterator {
      def foreach(f: T => Unit): Unit = while (hasNext) f(next())
    }
    // 把实现类和特质组合成一个类，实现多重继承
    class RichStringIter extends StringIterator("Scala") with RichIterator
    val richIterator = new RichStringIter
    richIterator.foreach(println)
  }

}
