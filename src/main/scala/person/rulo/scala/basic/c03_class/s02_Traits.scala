package person.rulo.scala.basic.c03_class

import scala.collection.mutable.ArrayBuffer

object s02_Traits {

  def main(args: Array[String]): Unit = {
    // 使用泛型和抽象方法定义一个特质
    trait Iterator[A] {
      def hasNext: Boolean
      def next(): A
    }
    // 使用extends关键字来扩展特征，然后使用override关键字来实现trait里面的任何抽象成员
    class IntIterator(to: Int) extends Iterator[Int] {
      private var cur = 0
      override def hasNext: Boolean = cur < to
      override def next(): Int = {
        if (hasNext) {
          val t = cur
          cur += 1
          t
        } else 0
      }
    }
    // 调用示例
    val iterator = new IntIterator(10)
    println(iterator.next())  // returns 0
    println(iterator.next())  // returns 1
    // 凡是需要特质的地方，都可以由该特质的子类型来替换
    trait Pet {
      val name: String
    }
    class Dog(val name: String) extends Pet
    class Cat(val name: String) extends Pet
    val dog = new Dog("Harry")
    val cat = new Cat("Sally")
    val animals = ArrayBuffer.empty[Pet]
    animals.append(dog)
    animals.append(cat)
    animals.foreach(pet => println(pet.name))
  }

}
