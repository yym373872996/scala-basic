package person.rulo.scala.basic.c03_class

object s10_LowerTypeBounds {

  def main(args: Array[String]): Unit = {
    // 用 >: 来表示类型下界
    trait List[+A] {
      def prepend[B >: A](elem: B): List[B]
    }

    case class NonEmptyList[+A](head: A, tail: List[A]) extends List[A] {
      override def prepend[B >: A](elem: B): List[B] = NonEmptyList(elem, this)
    }

    object Nil extends List[Nothing] {
      override def prepend[B >: Nothing](elem: B): List[B] = NonEmptyList(elem, this)
    }

    trait Bird
    case class AfricanSwallow() extends Bird
    case class EuropeanSwallow() extends Bird

    val africanSwallows: List[AfricanSwallow] = Nil.prepend(AfricanSwallow())
    val swallowsFromAntarctica: List[Bird] = Nil
    val someBird: Bird = EuropeanSwallow()

    // assign swallows to birds
    val birds: List[Bird] = africanSwallows
    println(birds)

    // add some bird to swallows, `B` is `Bird`
    val someBirds = africanSwallows.prepend(someBird)
    println(someBirds)

    // add a swallow to birds
    val moreBirds = birds.prepend(EuropeanSwallow())
    println(moreBirds)

    // add disparate swallows together, `B` is `Bird` because that is the supertype common to both swallows
    val allBirds = africanSwallows.prepend(EuropeanSwallow())
    println(allBirds)

    // but this is a mistake! adding a list of birds widens the type arg too much. -Xlint will warn!
    val error = moreBirds.prepend(swallowsFromAntarctica)    // List[Object]
    println(error)

  }

}
