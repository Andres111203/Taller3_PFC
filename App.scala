package taller

object App {
  def main(args: Array[String]): Unit = {
    println("Bienvenido al programa de multiplicación de matrices usando el algoritmo de Strassen.")

    // matrices de ejemplo
    val matrixA = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9)
    )

    val matrixB = Array(
      Array(9, 8, 7),
      Array(6, 5, 4),
      Array(3, 2, 1)
    )

    println("Matriz A:")
    FunExtra.printMatrix(matrixA)

    println("\nMatriz B:")
    FunExtra.printMatrix(matrixB)

    // Verificar si se pueden multiplicar
    if (FunExtra.validateMatrixMultiplication(matrixA, matrixB)) {
      // Multiplicación secuencial con Strassen
      println("\nMultiplicación usando el algoritmo de Strassen:")
      val resultStrassen = Strassen.multiply(matrixA, matrixB)
      FunExtra.printMatrix(resultStrassen)

      // Multiplicación paralela con StrassenPar
      println("\nMultiplicación paralela usando el algoritmo de Strassen:")
      val resultStrassenPar = StrassenPar.multiplyParallel(matrixA, matrixB)
      FunExtra.printMatrix(resultStrassenPar)
    } else {
      println("\nLas matrices no se pueden multiplicar debido a dimensiones incompatibles.")
    }
  }
}
