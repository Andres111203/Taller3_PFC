package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MultMatrizTest extends AnyFunSuite {
    
    val multMatriz = new MultMatriz()
    
    test("Multiplicación de matrices 1x1") {
        val m1 = Vector(Vector(2))
        val m2 = Vector(Vector(3))
        val expected = Vector(Vector(6))
        assert(multMatriz.multMatrizRecPar(m1, m2) == expected)
    }
    
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
        assert(multMatriz.multMatrizRecPar(m1, m2) == expected)
    }
    
    test("Multiplicación de matrices 4x4") {
        val m1 = Vector(
            Vector(1, 2, 3, 4),
            Vector(5, 6, 7, 8),
            Vector(9, 10, 11, 12),
            Vector(13, 14, 15, 16)
        )
        val m2 = Vector(
            Vector(1, 2, 3, 4),
            Vector(5, 6, 7, 8),
            Vector(9, 10, 11, 12),
            Vector(13, 14, 15, 16)
        )
        val expected = Vector(
            Vector(90, 100, 110, 120),
            Vector(202, 228, 254, 280),
            Vector(314, 356, 398, 440),
            Vector(426, 484, 542, 600)
        )
        assert(multMatriz.multMatrizRecPar(m1, m2) == expected)
    }
    
    // Nuevo test 1: Multiplicación de matrices 3x3
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
        assert(multMatriz.multMatrizRecPar(m1, m2) == expected)
    }
    
    // Nuevo test 2: Multiplicación de matrices 5x5
    test("Multiplicación de matrices 5x5") {
        val m1 = Vector(
            Vector(1, 0, 0, 0, 1),
            Vector(0, 1, 0, 1, 0),
            Vector(0, 0, 1, 0, 0),
            Vector(0, 1, 0, 1, 0),
            Vector(1, 0, 0, 0, 1)
        )
        val m2 = Vector(
            Vector(1, 2, 3, 4, 5),
            Vector(6, 7, 8, 9, 10),
            Vector(11, 12, 13, 14, 15),
            Vector(16, 17, 18, 19, 20),
            Vector(21, 22, 23, 24, 25)
        )
        val expected = Vector(
            Vector(22, 24, 26, 28, 30),
            Vector(22, 24, 26, 28, 30),
            Vector(11, 12, 13, 14, 15),
            Vector(22, 24, 26, 28, 30),
            Vector(22, 24, 26, 28, 30)
        )
        assert(multMatriz.multMatrizRecPar(m1, m2) == expected)
    }
    
    // Nuevo test 3: Multiplicación de matrices 6x6
    test("Multiplicación de matrices 6x6") {
        val m1 = Vector(
            Vector(1, 2, 3, 4, 5, 6),
            Vector(7, 8, 9, 10, 11, 12),
            Vector(13, 14, 15, 16, 17, 18),
            Vector(19, 20, 21, 22, 23, 24),
            Vector(25, 26, 27, 28, 29, 30),
            Vector(31, 32, 33, 34, 35, 36)
        )
        val m2 = Vector(
            Vector(36, 35, 34, 33, 32, 31),
            Vector(30, 29, 28, 27, 26, 25),
            Vector(24, 23, 22, 21, 20, 19),
            Vector(18, 17, 16, 15, 14, 13),
            Vector(12, 11, 10, 9, 8, 7),
            Vector(6, 5, 4, 3, 2, 1)
        )
        val expected = Vector(
            Vector(336, 315, 294, 273, 252, 231),
            Vector(912, 861, 810, 759, 708, 657),
            Vector(1488, 1407, 1326, 1245, 1164, 1083),
            Vector(2064, 1953, 1842, 1731, 1620, 1509),
            Vector(2640, 2499, 2358, 2217, 2076, 1935),
            Vector(3216, 3045, 2874, 2703, 2532, 2361)
        )
        assert(multMatriz.multMatrizRecPar(m1, m2) == expected)
    }
    
    // Nuevo test 4: Multiplicación de matrices identidad
    test("Multiplicación de matrices identidad") {
        val m1 = Vector(
            Vector(1, 0, 0, 0),
            Vector(0, 1, 0, 0),
            Vector(0, 0, 1, 0),
            Vector(0, 0, 0, 1)
        )
        val m2 = Vector(
            Vector(1, 2, 3, 4),
            Vector(5, 6, 7, 8),
            Vector(9, 10, 11, 12),
            Vector(13, 14, 15, 16)
        )
        val expected = m2
        assert(multMatriz.multMatrizRecPar(m1, m2) == expected)
    }
    
    // Nuevo test 5: Multiplicación de matrices con ceros
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
        assert(multMatriz.multMatrizRecPar(m1, m2) == expected)
    }
}
