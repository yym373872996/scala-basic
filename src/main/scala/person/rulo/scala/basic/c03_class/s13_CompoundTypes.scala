package person.rulo.scala.basic.c03_class

object s13_CompoundTypes {

  def main(args: Array[String]): Unit = {
    // 有时需要表明一个对象的类型是其他几种类型的子类型
    // 在 Scala 中，这可以表示成 复合类型，即多个类型的交集
    trait Cloneable extends java.lang.Cloneable {
      override def clone(): Cloneable = {
        super.clone().asInstanceOf[Cloneable]
      }
    }
    trait Resettable {
      def reset(): Unit
    }
    // 用 with 来连接多个类型
    def cloneAndReset(obj: Cloneable with Resettable): Cloneable = {
      val cloned = obj.clone()
      obj.reset()
      cloned
    }
  }

}
