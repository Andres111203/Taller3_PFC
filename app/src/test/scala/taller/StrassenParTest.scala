package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestStrassenPar extends AnyFunSuite {

  test("StrassenPar Test: Multiplicación básica 2x2 matrices") {
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

    val result = StrassenPar.strassenMultiply(a, b)
    assert(result.deep == expected.deep)
  }

  test("StrassenPar Test: Multiplicación básica 4x4 matrices") {
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

    val result = StrassenPar.strassenMultiply(a, b)
    assert(result.deep == expected.deep)
  }

  test("StrassenPar Test: Multiplicación de matrices 1x1") {
    val a = Array(Array(3))
    val b = Array(Array(7))
    val expected = Array(Array(21))

    val result = StrassenPar.strassenMultiply(a, b)
    assert(result.deep == expected.deep)
  }

  test("StrassenPar Test: Matrices grandes 8x8 con ceros y unos") {
    val a = Array.fill(8, 8)(1)
    val b = Array.fill(8, 8)(0)
    val expected = Array.fill(8, 8)(0)

    val result = StrassenPar.strassenMultiply(a, b)
    assert(result.deep == expected.deep)
  }

  test("StrassenPar Test: Verificar la adición de matrices") {
    val a = Array(
      Array(1, 2),
      Array(3, 4)
    )
    val b = Array(
      Array(5, 6),
      Array(7, 8)
    )
    val expected = Array(
      Array(6, 8),
      Array(10, 12)
    )

    val result = StrassenPar.addMatrices(a, b)
    assert(result.deep == expected.deep)
  }

  test("StrassenPar Test: Verificar la sustracción de matrices") {
    val a = Array(
      Array(5, 6),
      Array(7, 8)
    )
    val b = Array(
      Array(1, 2),
      Array(3, 4)
    )
    val expected = Array(
      Array(4, 4),
      Array(4, 4)
    )

    val result = StrassenPar.subtractMatrices(a, b)
    assert(result.deep == expected.deep)
  }
}