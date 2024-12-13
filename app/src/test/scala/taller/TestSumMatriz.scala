package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestSumMatriz extends AnyFunSuite {

    val obj = new SumMatriz()
    type Matriz = Vector[Vector[Int]]

    // Matrices de prueba
    val m1: Matriz = Vector(
        Vector(1, 2),
        Vector(3, 4)
    )
    val m2: Matriz = Vector(
        Vector(5, 6),
        Vector(7, 8)
    )

    // Resultado esperado
    val expected: Matriz = Vector(
        Vector(6, 8),
        Vector(10, 12)
    )

    // Suma de matrices
    val result: Matriz = obj.sumMatriz(m1, m2)

    test("SumMatriz Test: Suma correcta de elementos") {
        assert(result == expected, "La matriz resultante no coincide con la esperada.")
    }

    test("SumMatriz Test: Dimensiones de la matriz resultante") {
        assert(result.length == m1.length, "La cantidad de filas en la matriz resultante es incorrecta.")
        assert(result(0).length == m1(0).length, "La cantidad de columnas en la matriz resultante es incorrecta.")
    }

    test("SumMatriz Test: Suma de matrices vacías") {
        val emptyMatriz: Matriz = Vector()
        assert(obj.sumMatriz(emptyMatriz, emptyMatriz) == emptyMatriz, "La suma de matrices vacías debe dar una matriz vacía.")
    }

    test("SumMatriz Test: Suma de matrices de una celda") {
        val singleCell1: Matriz = Vector(Vector(2))
        val singleCell2: Matriz = Vector(Vector(3))
        val expectedSingle: Matriz = Vector(Vector(5))
        assert(obj.sumMatriz(singleCell1, singleCell2) == expectedSingle, "La suma de matrices de una celda no es correcta.")
    }
}
