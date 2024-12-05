package person.rulo.scala.basic.c03_class

object s07_GenericClasses {

  def main(args: Array[String]): Unit = {
    // 用泛型类实现栈
    class Stack[A] {
      private var elements: List[A] = Nil
      def push(x: A): Unit =
        elements = x :: elements
      def peek: A = elements.head
      def pop(): A = {
        val currentTop = peek
        elements = elements.tail
        currentTop
      }
    }
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    println(stack.pop())  // prints 2
    println(stack.pop())  // prints 1
    // 指定泛型的具体类型后，其子类型也可以被传入
    class Fruit
    class Apple extends Fruit
    class Banana extends Fruit
    val stack2 = new Stack[Fruit]
    val apple = new Apple
    val banana = new Banana
    stack2.push(apple)
    stack2.push(banana)
  }

}
