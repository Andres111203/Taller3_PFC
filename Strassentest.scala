package taller

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class StrassenTest extends AnyFlatSpec with Matchers {

  "Strassen.multiply" should "multiplicar matrices de enteros positivos de tamaño 2x2" in {
    val A = Vector(Vector(2, 4), Vector(6, 8))
    val B = Vector(Vector(1, 3), Vector(5, 7))
    val esperado = Vector(Vector(22, 34), Vector(46, 74))
    Strassen.multiply(A, B) shouldEqual esperado
  }

  it should "manejar matrices con valores negativos correctamente" in {
    val A = Vector(Vector(-1, -2), Vector(-3, -4))
    val B = Vector(Vector(2, 0), Vector(0, 2))
    val esperado = Vector(Vector(-2, -4), Vector(-6, -8))
    Strassen.multiply(A, B) shouldEqual esperado
  }

  it should "multiplicar matrices de diferentes valores, incluyendo ceros" in {
    val A = Vector(Vector(0, 1), Vector(2, 3))
    val B = Vector(Vector(4, 5), Vector(0, 0))
    val esperado = Vector(Vector(0, 0), Vector(8, 10))
    Strassen.multiply(A, B) shouldEqual esperado
  }

  it should "manejar matrices de mayor tamaño, como 3x3, correctamente" in {
    val A = Vector(
      Vector(1, 2, 3),
      Vector(4, 5, 6),
      Vector(7, 8, 9)
    )
    val B = Vector(
      Vector(9, 8, 7),
      Vector(6, 5, 4),
      Vector(3, 2, 1)
    )
    val esperado = Vector(
      Vector(30, 24, 18),
      Vector(84, 69, 54),
      Vector(138, 114, 90)
    )
    Strassen.multiply(A, B) shouldEqual esperado
  }

  it should "calcular correctamente cuando ambas matrices son iguales y cuadradas" in {
    val A = Vector(
      Vector(1, 2, 3),
      Vector(4, 5, 6),
      Vector(7, 8, 9)
    )
    val esperado = Vector(
      Vector(30, 36, 42),
      Vector(66, 81, 96),
      Vector(102, 126, 150)
    )
    Strassen.multiply(A, A) shouldEqual esperado
  }
}
