package person.rulo.scala.basic.c04_func

object s06_Operators {

  def main(args: Array[String]): Unit = {
    // scala中，运算符即是方法，任何具有单个参数的方法都可以用作中缀运算符
    // 使用点号调用
    10.+(1)
    // 中缀运算符方式更易读
    10 + 1
    // 可以使用任何合法标识符作为运算符，包括像add这样的名字或+这样的符号
    case class Vec(x: Double, y: Double) {
      def +(that: Vec) = Vec(this.x + that.x, this.y + that.y)
    }
    val vector1 = Vec(1.0, 1.0)
    val vector2 = Vec(2.0, 2.0)
    println(vector1 + vector2)
    // 另一个例子是使用 and 或 or 这样的方法名作为中缀运算符
    case class MyBool(x: Boolean) {
      def and(that: MyBool): MyBool = MyBool(this.x & that.x)
      def or(that: MyBool): MyBool = MyBool(this.x | that.x)
    }
    def not(some: MyBool): MyBool = MyBool(!some.x)
    val x = MyBool(true)
    val y = MyBool(false)
    val xor = (x or y) and not(x and y)
    println(xor)
  }

}
