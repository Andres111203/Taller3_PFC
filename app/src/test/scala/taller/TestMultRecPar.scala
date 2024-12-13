import org.scalatest.funsuite.AnyFunSuite

class MultiMatRecParTest extends AnyFunSuite {

    type Matriz = Vector[Vector[Int]]

    val multMatriz = new taller.MultiMatRecPar()

    test("Multiplicación de matrices 1x1") {
        val m1: Matriz = Vector(Vector(2))
        val m2: Matriz = Vector(Vector(3))
        val expected: Matriz = Vector(Vector(6))

        assert(multMatriz.multMatrizRecPar(m1, m2) == expected)
    }

    test("Multiplicación de matrices 2x2") {
        val m1: Matriz = Vector(
            Vector(1, 2),
            Vector(3, 4)
        )
        val m2: Matriz = Vector(
            Vector(5, 6),
            Vector(7, 8)
        )
        val expected: Matriz = Vector(
            Vector(19, 22),
            Vector(43, 50)
        )

        assert(multMatriz.multMatrizRecPar(m1, m2) == expected)
    }

    test("Multiplicación de matrices 4x4") {
        val m1: Matriz = Vector(
            Vector(1, 2, 3, 4),
            Vector(5, 6, 7, 8),
            Vector(9, 10, 11, 12),
            Vector(13, 14, 15, 16)
        )
        val m2: Matriz = Vector(
            Vector(16, 15, 14, 13),
            Vector(12, 11, 10, 9),
            Vector(8, 7, 6, 5),
            Vector(4, 3, 2, 1)
        )
        val expected: Matriz = Vector(
            Vector(80, 70, 60, 50),
            Vector(240, 214, 188, 162),
            Vector(400, 358, 316, 274),
            Vector(560, 502, 444, 386)
        )

        assert(multMatriz.multMatrizRecPar(m1, m2) == expected)
    }

    test("Multiplicación de matrices con ceros") {
        val m1: Matriz = Vector(
            Vector(0, 0, 0),
            Vector(0, 0, 0),
            Vector(0, 0, 0)
        )
        val m2: Matriz = Vector(
            Vector(1, 2, 3),
            Vector(4, 5, 6),
            Vector(7, 8, 9)
        )
        val expected: Matriz = Vector(
            Vector(0, 0, 0),
            Vector(0, 0, 0),
            Vector(0, 0, 0)
        )

        assert(multMatriz.multMatrizRecPar(m1, m2) == expected)
    }

    test("Multiplicación de matrices identidad") {
        val m1: Matriz = Vector(
            Vector(1, 0, 0),
            Vector(0, 1, 0),
            Vector(0, 0, 1)
        )
        val m2: Matriz = Vector(
            Vector(2, 3, 4),
            Vector(5, 6, 7),
            Vector(8, 9, 10)
        )
        val expected: Matriz = m2

        assert(multMatriz.multMatrizRecPar(m1, m2) == expected)
    }
}
