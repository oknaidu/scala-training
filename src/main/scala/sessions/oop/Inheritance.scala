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

  class Adult(name: String, age: Int, idCard: String) extends Person(name) //Person(name)

  val adult = new Adult("John", 25, "icard")

  //overriding
  class Dog(override val name: String) extends Animal {
    override def eat: Unit = println("dog food") //override method
  }

  val dog  = new Dog("Bruno")
  dog.eat

  //type substitution : polymorphism
  val unknown: Animal = new Dog("Marley")
  println(unknown.name)
  unknown.eat

  //preventing overrides
  // 1. using final keyword on membeers like methods and values
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
