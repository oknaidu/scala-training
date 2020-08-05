package sessions.oop

object AbstractDataType extends App {

  //situation where we need to leave fields and methods unimplemented  - abstract members

  //classes which contain unimplemented or abstract fields or methods
  //are called abstract classes and they are defined by the keyword abstract
  abstract class Employee {
    val aType : String //And notice we are not defining it;That means this value is abstract
    def work: Unit
  }

  // abstract classes cannot be instantiated
  //val emp = new Employee

  // they are meant to be extended later

  class Supervisor extends Employee {
    override val aType: String = "supervisor" //override key not mandatory

    override def work: Unit = println("supervisor work")
  }

  //TRAITS
  trait Reporter {
    def reportTo(employee: Employee) : Unit //traits by default like abstract classes have abstract method
  }

  // Like abstract classes , traits have absrract values and methods
  // However unlike abstract classes they can be inherited along classes

  // this basically means that the class FTE inherits members from both Employee and reporte
  class FTE extends Employee with Reporter {
  override val aType: String = "fte"

  override def work: Unit = println("fte work")

  override def reportTo(employee: Employee): Unit = println(s"$aType reports to ${employee.aType}")
  }

  val fte = new FTE
  val supervisor = new Supervisor
  fte.reportTo(supervisor)


  // we can mix multiple traits

  /*trait HasCustomerLaptop {
    val laptopType: String
  }
  class FTE extends Employee with Reporter with HasCustomerLaptop {
    override val aType: String = "fte"

    override def work: Unit = println("fte work")

    override def reportTo(employee: Employee): Unit = println(s"$aType reports to ${employee.aType}")

    override val laptopType: String = "MacBookPro"
  }

  */

  //difference between traits and abstract classes

  // simliarity - both can have abstract and non abstract methods and properties

  // 1. traits cannot have constructor parameters
  // trait SomeTrait(someparam: String) //does not compile

  // 2. Extend mutiple class but mixin mutiple traits
  // Scala has single class inheritance and  has multiple trait inheritance.
  // This is how you can implement multiple inheritance in Scott.


  // how to choose traits vs abstact class
  // So we choose a trait vs an abstract class if it describes a type of behavior.
  // traits =  behaviour
  // abstract class =  type of things

  // SCALAS TYPE HEIRARCHY

  // Type any which is basically the mother of all types.
  // Now derived from any we have any anyrref which is mapped to Java's object type.
  // All classes we will use will derive from anyref unless we explicitly say they extend some other class.
  // So all the classes that we use like string lists set and all user  derived classes will extend anyref

  // Now derived from all of these is the scala.Null type which is very special.
  // It's only instance is the null reference which basically means no reference.
  // This type hierarchy works this way so null extends basically everything
  // in the sense that you can replace anything For example a fte with no with no reference.

  val fte2: FTE = null

  // on the left hand side we have anyvals which contain all the primitive values of Scala like int, Unit , Float
  // very rarely you would use anyval

  // derived from all of these is Scala.Nothing
  // nothing can replace everything.
  // This will make sense a little bit later when we talk about throwing exceptions and expressions returning nothing
  // But nothing just so you know in Scala is a subtype of every single thing in scala
  // nothing means no instance of anything
  // There are expressions returning nothing and we'll talk about them later in the section.
}
