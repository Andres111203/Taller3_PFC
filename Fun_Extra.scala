package taller

object FunExtra {
  /**
   * Prints a matrix in a readable format.
   * 
   * @param matrix The matrix to print.
   */
  def printMatrix(matrix: Array[Array[Int]]): Unit = {
    matrix.foreach(row => println(row.mkString(" ")))
  }

  /**
   * Generates an identity matrix of a given size.
   * 
   * @param size The size of the identity matrix.
   * @return The identity matrix.
   */
  def generateIdentityMatrix(size: Int): Array[Array[Int]] = {
    Array.tabulate(size, size)((i, j) => if (i == j) 1 else 0)
  }

  /**
   * Validates if two matrices can be multiplied.
   * 
   * @param a The first matrix.
   * @param b The second matrix.
   * @return True if the matrices can be multiplied, false otherwise.
   */
  def validateMatrixMultiplication(a: Array[Array[Int]], b: Array[Array[Int]]): Boolean = {
    a.nonEmpty && b.nonEmpty && a.head.length == b.length
  }

  /**
   * Pads a matrix to the next power of two size.
   * 
   * @param matrix The matrix to pad.
   * @return The padded matrix.
   */
  def padMatrix(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val n = matrix.length
    val nextPowerOfTwo = math.pow(2, math.ceil(math.log(n) / math.log(2))).toInt
    val padded = Array.ofDim[Int](nextPowerOfTwo, nextPowerOfTwo)
    for (i <- matrix.indices; j <- matrix(i).indices) {
      padded(i)(j) = matrix(i)(j)
    }
    padded
  }
}
