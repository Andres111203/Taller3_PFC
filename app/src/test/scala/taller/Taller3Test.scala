package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TallerTresTest extends AnyFunSuite {
  val objTallerTres = new TallerTres()

  // Pruebas para la función subMatriz
  test("Extraer submatriz 2x2 de una matriz 4x4") {
    val matriz: objTallerTres.Matriz = Vector(
      Vector(1, 2, 3, 4),
      Vector(5, 6, 7, 8),
      Vector(9, 10, 11, 12),
      Vector(13, 14, 15, 16)
    )
    val resultadoEsperado: objTallerTres.Matriz = Vector(
      Vector(6, 7),
      Vector(10, 11)
    )
    assert(objTallerTres.subMatriz(matriz, 1, 1, 2) == resultadoEsperado)
  }

  test("Extraer submatriz 3x3 de una matriz 4x4") {
    val matriz: objTallerTres.Matriz = Vector(
      Vector(1, 2, 3, 4),
      Vector(5, 6, 7, 8),
      Vector(9, 10, 11, 12),
      Vector(13, 14, 15, 16)
    )
    val resultadoEsperado: objTallerTres.Matriz = Vector(
      Vector(1, 2, 3),
      Vector(5, 6, 7),
      Vector(9, 10, 11)
    )
    assert(objTallerTres.subMatriz(matriz, 0, 0, 3) == resultadoEsperado)
  }

  test("Extraer submatriz completa de una matriz 2x2") {
    val matriz: objTallerTres.Matriz = Vector(
      Vector(1, 2),
      Vector(3, 4)
    )
    val resultadoEsperado: objTallerTres.Matriz = Vector(
      Vector(1, 2),
      Vector(3, 4)
    )
    assert(objTallerTres.subMatriz(matriz, 0, 0, 2) == resultadoEsperado)
  }

  test("Error al intentar extraer submatriz con índices fuera de rango") {
    val matriz: objTallerTres.Matriz = Vector(
      Vector(1, 2, 3),
      Vector(4, 5, 6),
      Vector(7, 8, 9)
    )
    assertThrows[IllegalArgumentException] {
      objTallerTres.subMatriz(matriz, 1, 1, 4)
    }
  }

  test("Error al intentar extraer submatriz de tamaño negativo o cero") {
    val matriz: objTallerTres.Matriz = Vector(
      Vector(1, 2, 3),
      Vector(4, 5, 6),
      Vector(7, 8, 9)
    )
    assertThrows[IllegalArgumentException] {
      objTallerTres.subMatriz(matriz, 0, 0, 0)
    }
  }

  // Pruebas para la función restaMatriz
  test("Restar dos matrices 2x2") {
    val m1: objTallerTres.Matriz = Vector(
      Vector(1, 2),
      Vector(3, 4)
    )
    val m2: objTallerTres.Matriz = Vector(
      Vector(4, 3),
      Vector(2, 1)
    )
    val resultadoEsperado: objTallerTres.Matriz = Vector(
      Vector(-3, -1),
      Vector(1, 3)
    )
    assert(objTallerTres.restaMatriz(m1, m2) == resultadoEsperado)
  }

  test("Restar matrices de tamaño 3x3") {
    val m1: objTallerTres.Matriz = Vector(
      Vector(9, 8, 7),
      Vector(6, 5, 4),
      Vector(3, 2, 1)
    )
    val m2: objTallerTres.Matriz = Vector(
      Vector(1, 2, 3),
      Vector(4, 5, 6),
      Vector(7, 8, 9)
    )
    val resultadoEsperado: objTallerTres.Matriz = Vector(
      Vector(8, 6, 4),
      Vector(2, 0, -2),
      Vector(-4, -6, -8)
    )
    assert(objTallerTres.restaMatriz(m1, m2) == resultadoEsperado)
  }

  test("Error al intentar restar matrices de tamaños diferentes") {
    val m1: objTallerTres.Matriz = Vector(
      Vector(1, 2, 3),
      Vector(4, 5, 6)
    )
    val m2: objTallerTres.Matriz = Vector(
      Vector(7, 8, 9)
    )
    assertThrows[IllegalArgumentException] {
      objTallerTres.restaMatriz(m1, m2)
    }
  }
}
