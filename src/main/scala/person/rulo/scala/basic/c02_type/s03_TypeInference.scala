package person.rulo.scala.basic.c02_type

object s03_TypeInference {

  def main(args: Array[String]): Unit = {
    // 递归方法编译器无法推断返回类型，需要显式声明
    //    def fac(n: Int) = if (n == 0) 1 else n * fac(n - 1)
    def fac(n: Int): Int = if (n == 0) 1 else n * fac(n - 1)
    // 当使用泛型类和多态方法时，编译器能结合上下文推断出类型
    case class MyPair[A, B](x: A, y: B)
    val p = MyPair(1, "scala")
    def id[T](x: T) = x
    val q = id(1)
    // 编译器从不推断方法形式参数的类型
    // 但在某些情况下，当函数作为参数传递时，编译器可以推断出匿名函数形式参数的类型
    Seq(1, 3, 4).map(x => x * 2)
    // 类型推断有时会推断出太具体的类型，如下编译器会把类型推断为Null，并无法再为其分配值
    // 此时需要明确给出类型定义
//    var obj = null
//    obj = new AnyRef
  }

}
