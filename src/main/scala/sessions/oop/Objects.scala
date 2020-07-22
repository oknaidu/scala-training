package sessions.oop


object Objects extends App {

  //SOMETIMES WE HAVE CLASS LEVEL FUNCTIONALITY
  // we dont need an instance of an class for such functionality
  // see Test.java

  // SCALA does not have class level functionality
  // scala does not know the concept of static
  // it has something better called as objects
  object Person { //type + the only instance
    //"static"/ class level functionality
    val title : String = "Sir"

    val canFly: Boolean = false
    //objects can also have valid method definitions inside them
    // however object do not receive parameters

    //factory method
    def createPerson(firstName: String, lastName: String): Person = new Person(firstName + " "+ lastName)
    def apply(firstName: String, lastName: String): Person = new Person(firstName + " "+ lastName)
  }

  println(Person.title)
  println(Person.canFly)

  //differences between static approach and object
  // 1. Scala objects is a singleton instance
  // when we define a object , we define its type and the only instance of that type
  // clear from the the statements below

  val john = Person //john is an instance of type Person
  val mary = Person //same is Mary
  println(john == mary) //Mary and John point to same instance

  // A pattern often used in practise is classes and objects at same name
  class Person(name: String) {
    //instance level functionality
    def greet = s"Hello ${Person.title} $name"
  }

  //object+class in the same scope is called Companion object
  // Either we will access the code via regular instance (class) or the singleton instance (object)
  // in this sense Scala is truly a object oriented language that you need some instance to access code

  //however if we create instances using the new keyword
  val dave = new Person("dave")
  val mathew  = new Person("mathew")
  println(dave == mathew) //so these two are different
  //but the instace created by the keyword object is a singleton


  // factory methods arr often present in singleton object
  val person = Person.createPerson("John","Smith")
  println(person.greet)

  val person1 = Person.apply("John","Smith")
  val person2 = Person("John","Smith")
  println(person2.greet)

  // Scala applications =  Scala object with
  // def main(args: Array[String]): Unit
}
