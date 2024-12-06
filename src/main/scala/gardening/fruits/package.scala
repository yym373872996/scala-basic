package gardening

package object fruits {

  val planted: Seq[Fruit] = List(Apple, Plum, Banana)
  def showFruit(fruit: Fruit): Unit = {
    println(s"${fruit.name}s are ${fruit.color}")
  }

}
