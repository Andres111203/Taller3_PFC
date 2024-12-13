package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MultMatrizTest extends AnyFunSuite {

  val multMatriz = new MultMatSec()

  // Test 1: Multiplicación de matrices 1x1
  test("Multiplicación de matrices 1x1") {
    val m1 = Vector(Vector(2))
    val m2 = Vector(Vector(3))
    val expected = Vector(Vector(6))
    assert(multMatriz.multMatriz(m1, m2) == expected)
  }

  // Test 2: Multiplicación de matrices 2x2
  test("Multiplicación de matrices 2x2") {
    val m1 = Vector(
      Vector(1, 2),
      Vector(3, 4)
    )
    val m2 = Vector(
      Vector(5, 6),
      Vector(7, 8)
    )
    val expected = Vector(
      Vector(19, 22),
      Vector(43, 50)
    )
    assert(multMatriz.multMatriz(m1, m2) == expected)
  }

  // Test 3: Multiplicación de matrices 3x3
  test("Multiplicación de matrices 3x3") {
    val m1 = Vector(
      Vector(1, 2, 3),
      Vector(4, 5, 6),
      Vector(7, 8, 9)
    )
    val m2 = Vector(
      Vector(9, 8, 7),
      Vector(6, 5, 4),
      Vector(3, 2, 1)
    )
    val expected = Vector(
      Vector(30, 24, 18),
      Vector(84, 69, 54),
      Vector(138, 114, 90)
    )
    assert(multMatriz.multMatriz(m1, m2) == expected)
  }

  // Test 4: Multiplicación de matrices identidad
  test("Multiplicación de matrices identidad") {
    val m1 = Vector(
      Vector(1, 0, 0),
      Vector(0, 1, 0),
      Vector(0, 0, 1)
    )
    val m2 = Vector(
      Vector(2, 3, 4),
      Vector(5, 6, 7),
      Vector(8, 9, 10)
    )
    val expected = m2 // La matriz multiplicada por la identidad es ella misma
    assert(multMatriz.multMatriz(m1, m2) == expected)
  }

  // Test 5: Multiplicación de matrices con ceros
  test("Multiplicación de matrices con ceros") {
    val m1 = Vector(
      Vector(0, 0, 0),
      Vector(0, 0, 0),
      Vector(0, 0, 0)
    )
    val m2 = Vector(
      Vector(1, 2, 3),
      Vector(4, 5, 6),
      Vector(7, 8, 9)
    )
    val expected = Vector(
      Vector(0, 0, 0),
      Vector(0, 0, 0),
      Vector(0, 0, 0)
    )
    assert(multMatriz.multMatriz(m1, m2) == expected)
  }
}
