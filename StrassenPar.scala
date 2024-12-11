package taller

import scala.collection.parallel.CollectionConverters._

object StrassenPar {
  def addMatrices(a: Array[Array[Int]], b: Array[Array[Int]]): Array[Array[Int]] = {
    val n = a.length
    Array.tabulate(n, n)((i, j) => a(i)(j) + b(i)(j))
  }

  def subtractMatrices(a: Array[Array[Int]], b: Array[Array[Int]]): Array[Array[Int]] = {
    val n = a.length
    Array.tabulate(n, n)((i, j) => a(i)(j) - b(i)(j))
  }

  def strassenMultiply(a: Array[Array[Int]], b: Array[Array[Int]]): Array[Array[Int]] = {
    val n = a.length
    if (n == 1) {
      Array(Array(a(0)(0) * b(0)(0)))
    } else {
      val newSize = n / 2
      val (a11, a12, a21, a22) = splitMatrix(a)
      val (b11, b12, b21, b22) = splitMatrix(b)

      val tasks = Seq(
        () => strassenMultiply(addMatrices(a11, a22), addMatrices(b11, b22)),
        () => strassenMultiply(addMatrices(a21, a22), b11),
        () => strassenMultiply(a11, subtractMatrices(b12, b22)),
        () => strassenMultiply(a22, subtractMatrices(b21, b11)),
        () => strassenMultiply(addMatrices(a11, a12), b22),
        () => strassenMultiply(subtractMatrices(a21, a11), addMatrices(b11, b12)),
        () => strassenMultiply(subtractMatrices(a12, a22), addMatrices(b21, b22))
      )

      val results = tasks.par.map(_.apply())

      val c11 = addMatrices(subtractMatrices(addMatrices(results(0), results(3)), results(4)), results(6))
      val c12 = addMatrices(results(2), results(4))
      val c21 = addMatrices(results(1), results(3))
      val c22 = addMatrices(subtractMatrices(addMatrices(results(0), results(2)), results(1)), results(5))

      combineMatrices(c11, c12, c21, c22)
    }
  }

  def splitMatrix(matrix: Array[Array[Int]]): (Array[Array[Int]], Array[Array[Int]], Array[Array[Int]], Array[Array[Int]]) = {
    val n = matrix.length / 2
    val a11 = Array.ofDim[Int](n, n)
    val a12 = Array.ofDim[Int](n, n)
    val a21 = Array.ofDim[Int](n, n)
    val a22 = Array.ofDim[Int](n, n)

    for (i <- 0 until n; j <- 0 until n) {
      a11(i)(j) = matrix(i)(j)
      a12(i)(j) = matrix(i)(j + n)
      a21(i)(j) = matrix(i + n)(j)
      a22(i)(j) = matrix(i + n)(j + n)
    }

    (a11, a12, a21, a22)
  }

  def combineMatrices(a11: Array[Array[Int]], a12: Array[Array[Int]], a21: Array[Array[Int]], a22: Array[Array[Int]]): Array[Array[Int]] = {
    val n = a11.length
    val newSize = n * 2
    val result = Array.ofDim[Int](newSize, newSize)

    for (i <- 0 until n; j <- 0 until n) {
      result(i)(j) = a11(i)(j)
      result(i)(j + n) = a12(i)(j)
      result(i + n)(j) = a21(i)(j)
      result(i + n)(j + n) = a22(i)(j)
    }

    result
  }
}
