package sessions.oop

object Generics extends App {

  // lets create a generic collection type
  // a collection which can collect values of any type

  // So the way that we do that in the scala generics world would be to define a class my list parameterised
  // with a Type A Like I wrote here.
  class MyList[A] {
    // So the type A Here in between the square brackets denotes a generic type and once you define that you
    // can use the type A Inside the class definition.
  }

  val intList = new MyList[Int] // type Int betweeen the square brackets replaces the generic type

  val stringList = new MyList[String]
  //re-usability for all possible types that we can create a list for

  // my list parameterised with a is called a generic class in the Type A
  // A is called the Type Parameter. You can give it any name you want

  // we can also have multiple type parameters
  class MyMap[A,B]

  // generics can also be applied to traits.
  trait MyTrait[A]


  // generic methods

  // lets define small companion object for the my list class
  object MyList { //OBJECTS cannot have type parameters
    // a method that given a type parameter creates an empty mylist of that type
    def empty[A]: MyList[A] = new MyList[A]
    // just like traits and classes, once you declare type param in signature you
    // can use it in body and return type
  }

  val emptyIntList : MyList[Int] = MyList.empty[Int]
  println(emptyIntList)

  // so this is how we create classes , traits and methods with type parameters

  // Variance concept in Scala
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // questions
  // if Cat extends Animal , does List[Cat] extend List[Animal]

  // 1. yes - Covariance
  // This behavior is called covariance and the way that you declare a covariant list is to say class.
  //
  //Let's call this covariant list and in the type parameter here in between square brackets you put in
  //
  //a little plus a plus a means that this is a covariant list.
  class MyCovariantList[+A]

  // Now the way that you would use a covariant list is in the same style that you would use cats for animals.
  // So in the same style that you would save animal type 2 of the type animal because new cat.
  val animal : Animal = new Cat

  //So if say animal list which is a covariant list of animal and instead of covariant list of animal
  // I just put in a new covariant list of cat and this would work well.
  val animalList: MyCovariantList[Animal] = new MyCovariantList[Cat]

  // question about animal list
  // what elements can i add inside that list?
  // can i add a Dog?

  // 2. Invariant

  // This behavior is called invariance
  //
  //  Let's call this invariant list and in the type parameter you put no sign in front of it
  //
  class MyInvariantList[A]


  // So if say animal list which is a invariant list of animal and instead of invariant list of animal
  // I just put in a new invariant list of cat , then it will not work
  //val animalInvariantList: MyInvariantList[Animal] = new MyInvariantList[Cat]
  val animalInvariantList: MyInvariantList[Animal] = new MyInvariantList[Animal]

  // 3. Contravariant
  // if Cat extends Animal , then List[Animal] extends List[Cat]
  class MyContraVariantList[-A]
  val animalContraList: MyContraVariantList[Cat] = new MyContraVariantList[Animal]
}
