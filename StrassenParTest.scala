package taller

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class StrassenTest extends AnyFlatSpec with Matchers {

  "Strassen.multiply" should "multiplicar correctamente dos matrices de tamaño 2x2" in {
    val A = Vector(Vector(1, 2), Vector(3, 4))
    val B = Vector(Vector(5, 6), Vector(7, 8))
    val esperado = Vector(Vector(19, 22), Vector(43, 50))
    Strassen.multiply(A, B) shouldEqual esperado
  }

  it should "multiplicar correctamente dos matrices de tamaño 4x4" in {
    val A = Vector.fill(4, 4)(1)
    val B = Vector.fill(4, 4)(2)
    val esperado = Vector.fill(4, 4)(8)
    Strassen.multiply(A, B) shouldEqual esperado
  }

  it should "devolver la matriz cero al multiplicar con una matriz cero" in {
    val A = Vector.fill(4, 4)(1)
    val B = Vector.fill(4, 4)(0)
    val esperado = Vector.fill(4, 4)(0)
    Strassen.multiply(A, B) shouldEqual esperado
  }

  it should "multiplicar correctamente matrices de tamaño mayor como 8x8" in {
    val A = Vector.fill(8, 8)(3)
    val B = Vector.fill(8, 8)(1)
    val esperado = Vector.fill(8, 8)(24)
    Strassen.multiply(A, B) shouldEqual esperado
  }

  it should "manejar correctamente el caso de matrices de identidad" in {
    val identidad = (size: Int) => Vector.tabulate(size, size) { (i, j) => if (i == j) 1 else 0 }
    val A = Vector.fill(4, 4)(2)
    val B = identidad(4)
    Strassen.multiply(A, B) shouldEqual A
  }
}
