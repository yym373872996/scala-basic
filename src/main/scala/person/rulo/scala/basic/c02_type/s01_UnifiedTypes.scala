package person.rulo.scala.basic.c02_type

object s01_UnifiedTypes {

  def main(args: Array[String]): Unit = {
    /** 类型层次结构 */
    // Any是所有类的超类
    // AnyVal是所有值类型的超类，值类型是非空的，分别是：Double, Float, Long, Int, Short, Byte, Char, Unit
    // AnyRef是所有引用类型的超类，相当于java的java.lang.Object
    val list: List[Any] = List(
      "a string",
      732,  // an integer
      'c',  // a character
      true, // a boolean value
      () => "an anonymous function returning a string"
    )
    list.foreach(element => println(element))
    // Nothing是所有类型的子类型，也称为底部类型，其用途之一是给出非正常终止信号，如抛出异常、程序退出或无限循环
    // Nothing可以理解为不对值定义的表达式的类型，或是一个不能正常返回的方法
    // Null是所有引用类型的子类型，由关键字null定义
    val nullValue: Null = null
    /** 类型转换 */
    // 可直接转换 Byte -> Short -> Int -> Long -> Float -> Double
    val x: Long = 987654321
    val y: Float = x.toFloat  // 9.8765434E8 (note that some precision is lost in this case)
    // 逆向转换会编译不通过
//    val z: Long = y  // Does not conform
    // 可直接转换 Char -> Int
    val face: Char = '☺'
    val number: Int = face  // 9786
  }

}
