package person.rulo.scala.basic.c04_func

object s04_ImplicitParams {

  def main(args: Array[String]): Unit = {
    abstract class Monoid[A] {
      def add(x: A, y: A): A
      def unit: A
    }
    // implicit 关键字表示可以隐式使用相应的对象
    implicit val stringMonoid: Monoid[String] = new Monoid[String] {
      override def add(x: String, y: String): String = x concat y
      override def unit: String = ""
    }
    implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
      override def add(x: Int, y: Int): Int = x + y
      override def unit: Int = 0
    }
    // Scala 在调用包含有隐式参数块的方法时，将首先查找可以直接访问的隐式定义和隐式参数 (无前缀)
    def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
      if (xs.isEmpty) m.unit
      else m.add(xs.head, sum(xs.tail))

    val sum1 = sum(List(1, 2, 3))
    println(sum1)
    val sum2 = sum(List("a", "b", "c"))
    println(sum2)

  }

}
