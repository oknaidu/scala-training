package exercises.basics

object Exercise extends App {

  /**
   * 1. A greeting function (name, age) => "Hi , my name is $name and my age is $age"
   */
  def greeting(name: String, age: Int): String = {
    s"Hi, my name is $name and my age is $age"
  }


  /**
   * 2. A factorial function
   */
  def factorial(n: Int, result: Int = 1): Int = {
    if (n == 1)
      return result;
    else
      factorial(n - 1, result * n)
  }


  /**
   * 3. Test if a number is prime
   */
  def isPrime(n: Int, diviser: Int = 2): Boolean = {
    if (n == 0 || n == 1)
      return false;
    else if (n == 2)
      return true;
    else {
      if (diviser > n / 2)
        return true;
      if (n % diviser == 0)
        return false;
      else
        return isPrime(n, diviser + 1)
    }


  }

  println(greeting("kumar", 10))
  println(factorial(5))
  println(isPrime(11))
}
