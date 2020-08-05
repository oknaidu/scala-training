package sessions.oop

object Exceptions extends App {

  //from some method or from some other piece of code returns NULL

  val x: String = null

  //println(x.length)

  //technical translation for this absolutely crappy situation is that this method length when accessed
  //or when called throws the nullpointer exception and nobody's there to catch it. Hence the JVM crashes

  // throwing and catching exceptions

  // 1. How to throw exceptions
  // we can throw an exception by using the keyword throw

  //throw new NullPointerException //this expression throws an exception
  // since its an expression we can assign it to a val/var
  //val wierd  = throw new NullPointerException
  //So if I hover over a weird value it says a weird value is nothing.
  //So this doesn't actually hold a value but can be assigned to things.

  // nothing is a substitute for anything
  //val wierd1: String  = throw new NullPointerException

  // Now the property of a class to be thrown is restricted by that class extending or deriving from the
  // throwable type

  //class MyException extends Throwable
  //throw new MyException

  // 2. how to catch exceptions

  def getInt(withExceptions: Boolean): Int = {
    if(withExceptions) throw new RuntimeException("get int threw runtime exception")
    else 42
  }

  try {
    getInt(true)
  }
  catch {
    case e: RuntimeException => println(s"caught: ${e.getMessage}")
  }
  finally {
    println("finally always gets executed")
  }

  try {
    getInt(true)
  }
  catch {
    case e: NullPointerException => println(s"caught: ${e.getMessage}")
  }
  finally {
    println("finally always gets executed")
  }

  // like everything else, try/catch/finally is also an expression

  val fail = try {
    getInt(true)
  }
  catch {
    case e: RuntimeException => println(s"caught: ${e.getMessage}")
  }
  finally {
    println("finally always gets executed")
  }

  // fail is of type AnyVal
  // try block returns an Int
  // but the value returned from catch block is Unit
  // Int/Unit have the same supertype AnyVal

  // the finally block is optional
  // the value of expression inside finally does not impact the value of the entire try/catch/finally expression
  // finally does not influence the return type of this expression.

  // generally finally is used for side effects, like logging something etc.
}
