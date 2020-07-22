package sessions.oop

object OOBasics extends App {

  //lets instantiate an instance of person class
  val person = new Person("John", 26)

  println(person.age)
  println(person.x)

  person.greet("Will")
}


// lets create a class
//class Person(name: String, age: Int) //constructor
// name and age are class parameters but its not a class FIELDS THAT CAN BE ACCESSED with dot parameter


// class parameters are NOT FIELDS
// ADDING A VAL OR VAR KEYWORD to the class parameters will make it a class field
class Person(name: String, val age: Int) { //curly braces are class delimiters
  // body goes here
  // body is just the definition of a class
  // body can have val/var definition, functions definitions(methods), expressions

  val x = 2 // value/var definitions are fields, can be accessed using dot operator

  //functions defined inside a class definition are called methods
  def greet : Unit = println(s"Hi, my name is $name")

  //EXPRESSIONS
  println("class") // this gets printed when we create a new class. That is because the entire block is evaluated

  //within the class definition class parameters are accessible

  //def greet(name: String): Unit = println(s"$name says : hello $name")
  def greet(name: String): Unit = println(s"${this.name} says : hello $name")
  //this keyword is a handle to the current class instance

  // also greet method is overloaded : same name ; different signatures

  // multiple constructors
  def this(name: String) = {
    //println("nothing allowed here")
    this(name, 0) //this can also be solved by making age a default parameters
  }
}
