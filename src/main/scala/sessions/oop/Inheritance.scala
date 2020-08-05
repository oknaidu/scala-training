package sessions.oop

object Inheritance extends App {

  //single class inheritance in scala

  class Animal  {

    val name = "animal"
    //3 types of modifiers - default(public). private and protected
    def eat = println("animal eat")

    private def sleep = println("animal sleep")

    protected def drink = println("animal drink")
  }

  class Cat extends Animal { //inheriting all non private fields and methods

    def catDrink =  {
      drink
      println("cat drink")
    }

    def catSleep = {
      //drink
      println("cat sleeps")
    }
  }


  val cat = new Cat
  cat.eat
  cat.catDrink
  cat.catSleep


  //constructors


  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 10)
  }

  //class Adult(name: String,age: Int, idCard: String) extends Person

  // this code does not cmpile bcz when u instantiate the derived class , the jvm will also call
  // the parent constructor first, so a person constructor is called first when we instantiate Adult
  // so the compiler is forcing us to ensure that is a callable super class constructor
  // in thee above case it looks for a Person construcutor with no parameters and that does not exist


  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // this is the correct way of extending a class with parameters

  // if we have an auxillary constructor in our person class
  // then we can also specify that constructor in the extends clause
  class Adult1(name: String, age: Int, idCard: String) extends Person(name)


  val adult = new Adult("John", 25, "icard")

  //overriding

  // a dog class which is a sub class on Animal
  class Dog extends Animal {

    // lets suppose we want to provide a different implementation of eat for dog instance
    // the way we would do that is by using the keyword override
    override def eat: Unit = println("dog food") //override method
  }

  val dog  = new Dog
  dog.eat

  // overriding also works for fields just like it works for methods
  // if we have a val called name in the parent class


  class PetDog extends Dog {
    //pet dog can override that name and we can give it another value
    override val name: String = "bla-bla"
  }

  val petDog = new PetDog
  println(petDog.name)

  // fields also have this proprety that they can be overrriden in the constructor
  // so i can place thee oveerride syntax in the class parameters

  class PetDog1(override val name: String) extends Dog

  // above is same as
  //class PetDog1(param: String) extends Dog {
  //  override val name: String = this.param
  //}

  val petDog1 = new PetDog1("petdog2")
  println(petDog1.name)

  // The main idea behind overriding is that the
  // instances should use the overiden metthods whenerver possible

  // we can also use type substitution to call overriden methods

  //Lets create an unknown animal and we specifically declare this to be an animal.
  //And on the right hand side I'm passing in an expression that constructs a new PetDog
  val unknown: Animal = new PetDog1("Marley")


  println(unknown.name)
  unknown.eat

  //although declared an animal is actually an instance of dog so it will use dogs method instead.
  //So keep in mind a method call will always go to the most overridden version whenever possible
  //This is one of the main powers of polymorphism.

  //preventing overrides
  // 1. using final keyword on members like methods and values
  class Parent  {
    final def parentMethod : Int = 42
    final val parentValue = 50
  }

  class Child extends Parent {
    //override def parentMethod: Int = 45
    //override val parentValue: Int = 55
  }

  // 2. Use final on class
  final class ParentTwo {
    def method = 60
  }

  //class ChildTwo extends ParentTwo

  // 3. Use the sealed keyword
  sealed class AnotherParent

  class AnotherChild extends AnotherParent //extension allowed only in this file
}
