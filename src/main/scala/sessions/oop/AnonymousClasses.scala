package sessions.oop

object AnonymousClasses extends App {

  //So I'm going to define a trait called animal and with a method Def eat

  trait Animal {
    def eat: Unit
  }

  val funny = new Animal {
    override def eat: Unit = println("anon??")
  }

  // So what we did here is
  // we instantiated an abstract class/trait

  println(funny.getClass)

  // So what actually happened when we wrote this is that the compiler took this part right here.
  // The animal with the curly braces and actually created a class with a funny name like sessions.anon$$

  /**
   *
   * class AnonymousClasses$$anon$1 extends Animal {
   * override def eat: Unit = println("anon??")
   * }
   *
   * val funny = new AnonymousClasses$$anon$1
   */

  // the above is what compiler does in the background


  // We can create anonymous class for non-abstract types as well
  class Person(name: String) {
    def greet: String = s"hello from $name"
  }

  val jim = new Person("jim") {
    override def greet: String = "hello from Jim"
  }

  println(jim.greet)
}
