package taller

class MultMatSec(){

    type Matriz = Vector[Vector[Int]]

    def prodPunto ( v1 : Vector [ Int ] , v2 : Vector [ Int ] ) : Int ={
        ( v1 zip v2 ).map({ case (i, j) => (i*j) }).sum
    }
    def transpuesta(m: Matriz ): Matriz = {
        val l =m.length
        Vector.tabulate( l , l ) ( (i,j) => m(j)(i))
    }
    def multMatriz (m1: Matriz , m2: Matriz ) : Matriz = {

       val l = m1.length
       val c = m2.length
       val matMult = transpuesta(m2)
       val res = Vector.tabulate(l,c)((i,j) => prodPunto(m1(i), matMult(j)))
       res      
    }   
}