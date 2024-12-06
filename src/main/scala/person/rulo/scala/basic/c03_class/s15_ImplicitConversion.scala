package person.rulo.scala.basic.c03_class

object s15_ImplicitConversion {

  def main(args: Array[String]): Unit = {
    // 隐式转换可以扩展现有类型的功能，比如为现有类添加额外方法或操作符
    implicit class IntExtensions(value: Int) {
      def squared: Int = value * value
    }
    val num = 5
    val squaredNum = num.squared
    println(squaredNum)
    // 隐式转换也可实现类型间自动转换
    implicit def stringSeqToIntSeq(strSeq: Seq[String]): Seq[Int] = strSeq.map(_.toInt)
    def sum(seq: Seq[Int]) = seq.sum
    val strSeq: Seq[String] = List("123", "456")
    println(sum(strSeq))
  }

}
