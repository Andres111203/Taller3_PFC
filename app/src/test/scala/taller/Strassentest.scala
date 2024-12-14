package taller

import org.scalatest.funsuite.AnyFunSuite

class StrassenTests extends AnyFunSuite {

  test("Multiplicación de matrices 1x1") {
    val a = Array(Array(3))
    val b = Array(Array(4))
    val expected = Array(Array(12))

    val result = Strassen.strassenMultiply(a, b)

    assert(result === expected)
  }

  test("Multiplicación de matrices 2x2 con valores simples") {
    val a = Array(
      Array(1, 2),
      Array(3, 4)
    )
    val b = Array(
      Array(5, 6),
      Array(7, 8)
    )
    val expected = Array(
      Array(19, 22),
      Array(43, 50)
    )

    val result = Strassen.strassenMultiply(a, b)

    assert(result === expected)
  }

  test("Multiplicación de matrices identidad 2x2") {
    val identity = Array(
      Array(1, 0),
      Array(0, 1)
    )
    val matrix = Array(
      Array(3, 4),
      Array(5, 6)
    )
    val expected = matrix

    val result = Strassen.strassenMultiply(matrix, identity)

    assert(result === expected)
  }

  test("Multiplicación de matrices cero 2x2") {
    val zeroMatrix = Array(
      Array(0, 0),
      Array(0, 0)
    )
    val matrix = Array(
      Array(3, 4),
      Array(5, 6)
    )
    val expected = zeroMatrix

    val result = Strassen.strassenMultiply(matrix, zeroMatrix)

    assert(result === expected)
  }

  test("Multiplicación de matrices 4x4 (comprobación básica)") {
    val a = Array(
      Array(1, 2, 3, 4),
      Array(5, 6, 7, 8),
      Array(9, 10, 11, 12),
      Array(13, 14, 15, 16)
    )
    val b = Array(
      Array(16, 15, 14, 13),
      Array(12, 11, 10, 9),
      Array(8, 7, 6, 5),
      Array(4, 3, 2, 1)
    )

    val expected = Array(
      Array(80, 70, 60, 50),
      Array(240, 214, 188, 162),
      Array(400, 358, 316, 274),
      Array(560, 502, 444, 386)
    )

    val result = Strassen.strassenMultiply(a, b)

    assert(result === expected)
  }

  test("Multiplicación de matrices no cuadradas debe lanzar excepción") {
    val a = Array(
      Array(1, 2, 3),
      Array(4, 5, 6)
    )
    val b = Array(
      Array(7, 8),
      Array(9, 10),
      Array(11, 12)
    )

    assertThrows[IllegalArgumentException] {
      Strassen.strassenMultiply(a, b)
    }
  }
}
