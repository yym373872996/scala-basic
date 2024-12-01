package person.rulo.scala.basic.c03_class

object s01_Classes {

  def main(args: Array[String]): Unit = {
    /** 通过默认值创建对象 */
    // 定义一个类，包含两个带默认初始值的变量，一个方法，一个重写toString方法
    class Point(var x: Int = 0, var y: Int = 0) {

      def move(dx: Int, dy: Int): Unit = {
        x = x + dx
        y = y + dy
      }

      override def toString: String =
        s"($x, $y)"
    }

    // 使用默认值
    val origin = new Point    // x and y are both set to 0
    // 只传递x，y使用默认值
    val point = new Point(1) // x is set to 1 and y is set to 0
    println(point)           // prints (1, 0)
    // 只传递y，x使用默认值
    val point1 = new Point(y = 2)
    println(point1)               // prints (0, 2)
    /** 使用对象的构造器和访问器 */
    // 定义一个类，将成员变量设置为私有的，并设置get和set方法
    // 包含getter和setter的私有成员变量必须以_开头命名
    // get方法名必须为去除_的变量名
    // set方法名必须为去除_的变量名后跟_=
    class Point2 {
      private var _x = 0
      private var _y = 0
      private val bound = 100

      def x: Int = _x
      def x_= (newValue: Int): Unit = {
        if (newValue < bound) _x = newValue else printWarning()
      }

      def y: Int = _y
      def y_= (newValue: Int): Unit = {
        if (newValue < bound) _y = newValue else printWarning()
      }

      private def printWarning(): Unit = println("WARNING: Out of bounds")
    }
    val point2 = new Point2
    // 使用成员变量赋值的方式，实际上调用的是构造器方法
    point2.x = 99
    point2.y = 101
    // 使用直接访问成员变量的方式，实际上调用的是访问器方法
    println(point2.x)
    /** 主构造方法中变量的可见性 */
    // 主构造方法中带有val和var的参数是公有的，但val是不可变的
    class Point3(val x: Int, val y: Int)
    val point3 = new Point3(1, 2)
//    point3.x = 3  // <-- does not compile
    // 不带val或var的参数是私有的
    class Point4(x: Int, y: Int)
    val point4 = new Point4(1, 2)
//    point4.x  // <-- does not compile
  }

}
