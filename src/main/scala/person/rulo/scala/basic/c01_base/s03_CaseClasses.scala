package person.rulo.scala.basic.c01_base

object s03_CaseClasses {

  def main(args: Array[String]): Unit = {
    // 样例类，一般用于不可变对象，其比较是基于值的，而非引用
    case class Point(x: Int, y: Int)
    // 样例类可以不需要关键字new来实例化
    val point = Point(1, 2)
    val anotherPoint = Point(1, 2)
    val yetAnotherPoint = Point(2, 2)
    // 样例类之间的比较是通过其内部成员的值而不是引用
    if (point == anotherPoint) {
      println(s"$point and $anotherPoint are the same.")
    } else {
      println(s"$point and $anotherPoint are different.")
    } // Point(1,2) and Point(1,2) are the same.
    if (point == yetAnotherPoint) {
      println(s"$point and $yetAnotherPoint are the same.")
    } else {
      println(s"$point and $yetAnotherPoint are different.")
    } // Point(1,2) and Point(2,2) are different.
  }

}
