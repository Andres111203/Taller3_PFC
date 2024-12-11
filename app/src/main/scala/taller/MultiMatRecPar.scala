import scala.collection.parallel.CollectionConverters._
import scala.collection.parallel._

package taller

class MultiMatRecPar () {

    type Matriz = Vector[Vector[Int]]
    def subMatriz(m: Matriz, i: Int, j: Int, l: Int): Matriz = {
        m.slice(i, i + l).map(row => row.slice(j, j + l))
    }

    def sumMatriz(m1: Matriz, m2: Matriz): Matriz = {
        val n = m1.length
        require(m1.length == m2.length && m1(0).length == m2(0).length)
        val resultado = Vector.tabulate(n, n)((i, j) => m1(i)(j) + m2(i)(j))
        resultado
    }





    def multMatrizRecPar(matriz1: Matriz, matriz2: Matriz): Matriz = {
        val n = matriz1.length
        if (n == 1) {
            
            Vector(Vector(matriz1(0)(0) * matriz2(0)(0)))
        } else {
            val medio = n / 2
            
            val matriz1A = subMatriz(matriz1, 0, 0, medio)
            val matriz1B = subMatriz(matriz1, 0, medio, medio)
            val matriz1C = subMatriz(matriz1, medio, 0, medio)
            val matriz1D = subMatriz(matriz1, medio, medio, medio)
            
        
            val matriz2A = subMatriz(matriz2, 0, 0, medio)
            val matriz2B = subMatriz(matriz2, 0, medio, medio)
            val matriz2C = subMatriz(matriz2, medio, 0, medio)
            val matriz2D = subMatriz(matriz2, medio, medio, medio)

            
            val (p1, p2, p3, p4, p5, p6, p7, p8) = (
            task { multMatrizRecPar(matriz1A, matriz2A) },
            task { multMatrizRecPar(matriz1B, matriz2C) },
            task { multMatrizRecPar(matriz1A, matriz2B) },
            task { multMatrizRecPar(matriz1B, matriz2D) },
            task { multMatrizRecPar(matriz1C, matriz2A) },
            task { multMatrizRecPar(matriz1D, matriz2C) },
            task { multMatrizRecPar(matriz1C, matriz2B) },
            task { multMatrizRecPar(matriz1D, matriz2D) }
            ).map(_.join())

            
            val top_left = sumMatriz(p1, p2)
            val top_right = sumMatriz(p3, p4)
            val bottom_left = sumMatriz(p5, p6)
            val bottom_right = sumMatriz(p7, p8)
            
            
            Vector.tabulate(n, n) { (i, j) =>
            if (i < medio && j < medio) top_left(i)(j)
            else if (i < medio && j >= medio) top_right(i)(j - medio)
            else if (i >= medio && j < medio) bottom_left(i - medio)(j)
            else bottom_right(i - medio)(j - medio)
        }
    }
    }

}