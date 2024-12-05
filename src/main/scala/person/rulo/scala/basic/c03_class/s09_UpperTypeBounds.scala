package person.rulo.scala.basic.c03_class

object s09_UpperTypeBounds {

  def main(args: Array[String]): Unit = {
    // 用 <: 来表示类型上界
    abstract class Animal {
      def name: String
    }
    abstract class Pet extends Animal {}
    class Cat extends Pet {
      override def name: String = "Cat"
    }
    class Dog extends Pet {
      override def name: String = "Dog"
    }
    class Lion extends Animal {
      override def name: String = "Lion"
    }
    class PetContainer[P <: Pet](p: P) {
      def pet: P = p
    }
    val dogContainer = new PetContainer[Dog](new Dog)
    val catContainer = new PetContainer[Cat](new Cat)
    println(dogContainer.pet.name)
    println(catContainer.pet.name)
    // 编译不通过
//    val lionContainer = new PetContainer[Lion](new Lion)
  }

}
