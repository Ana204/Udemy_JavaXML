import kotlin.math.pow

class Pessoa(Nome: String, idade: Int) {

    var altura: Double = 0.0
    var peso: Double? = null
    var imc: Double? = null

    fun calcularIMC() {

        imc = peso!!.div(altura?.pow(2))

        println("IMC: $imc")
    }
}