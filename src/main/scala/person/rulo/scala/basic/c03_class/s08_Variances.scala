package person.rulo.scala.basic.c03_class

object s08_Variances {

  def main(args: Array[String]): Unit = {
    // 型变是复杂类型的子类型关系与其组件类型的子类型关系的相关性
    // Scala支持泛型类的型变种类包含协变、逆变、和没有使用注释下的不变
    class Foo[+A] // A covariant class
    class Bar[-A] // A contravariant class
    class Baz[A]  // An invariant class
    // 没使用型变注释时默认为不变
    // 直接使用父类型对象来接收子类型对象是可行的，但是这种情况在类型作为泛型类时是不可行的
    // 比如以下例子，Animal是Cat的父类型，但并不能用Box[Animal]来接收Box[Cat]的值
    // 原因是Box[Animal]也能接收Dog类型的值，如果把已经定义为Cat类型的变量用Dog类型变量来赋值，就破坏了类型安全的原则
    class Box[A](var content: A)
    abstract class Animal {
      def name: String
    }
    case class Cat(name: String) extends Animal
    case class Dog(name:String) extends Animal
    val myCatBox: Box[Cat] = new Box[Cat](Cat("Felix"))
    // 这里不能被编译通过，因为把Box[Cat]对象赋给Box[Animal]，会破坏类型安全
//    val myAnimalBox: Box[Animal] = myCatBox // this doesn't compile
    // 如果子类型对应的变量是不可变的，那么就不会出现类型安全问题
    // 意味着一旦定义了变量为某种子类如Cat类型，则该变量不可能再被修改为其他子类型如Dog
    // 此时可以将泛型类定义为协变的，这样就可以遵循泛型类的子类传递关系了
    // 也就是说协变一般和val一起搭配使用
    class ImmutableBox[+A](val content: A)
    val catBox: ImmutableBox[Cat] = new ImmutableBox[Cat](Cat("Felix"))
    val animalBox: ImmutableBox[Animal] = catBox
    println(animalBox.content)
    // 下面例子展示了协变在提高方法可用性上的作用
    def printAnimalNames(animals: List[Animal]): Unit = {
      animals.foreach(animal => println(animal.name))
    }
    val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
    val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))
    // 如果List[A]不是协变的，以下两行不能通过编译
    printAnimalNames(cats)
    printAnimalNames(dogs)
    // 协变限制了我们对变量的更新，但允许我们取用
    // 反过来，如果我们只能对变量更新，但不能取用，这就是逆变
    // 逆变作用的场景可以是序列化器这种，传入一个类型A并转换成序列化值
    abstract class Serializer[-A] {
      def serialize(a: A): String
    }
    val animalSerializer = new Serializer[Animal] {
      override def serialize(animal: Animal): String = s"""{ "name": "${animal.name}" }"""
    }
    val catSerializer: Serializer[Cat] = animalSerializer
    println(catSerializer.serialize(Cat("Felix")))
    // 总结1：scala的型变相对于java而言
    // 协变：+T 相当于 ? extends T
    // 逆变：-T 相当于 ? super T
    // 不变：T 相当于 T
    // 总结2：scala函数的参数是逆变的，函数的返回值是协变的，java支持返回值协变，但不支持参数逆变
  }

}
