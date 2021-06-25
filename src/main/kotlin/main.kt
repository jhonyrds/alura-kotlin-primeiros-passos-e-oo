fun main() {
    println("Bem vindo ao Bytebank!")

    val contaJhony = Conta(titular = "Jhony", numero = 1000)
    contaJhony.deposito(100.0)

    println(contaJhony.titular)
    println(contaJhony.numero)
    println(contaJhony.saldo)

    val contaStephanie = Conta(titular = "Stephanie", numero = 1001)
    contaStephanie.deposito(100.00)

    println(contaStephanie.titular)
    println(contaStephanie.numero)
    println(contaStephanie.saldo)

    println("depositando na conta do Jhony")
    contaJhony.deposito(50.0)
    println(contaJhony.saldo)
    println("sacando na conta da Stephanie")
    contaStephanie.saque(10.0)
    println(contaStephanie.saldo)

    println("saque em excesso na conta do Jhonny")
    contaJhony.saque(500.0)
    println(contaJhony.saldo)

    println("saque em excesso na conta da Stephanie")
    contaStephanie.saque(1000.0)
    println(contaStephanie.saldo)

    println("Realizando transferência da conta da Stephanie para o Jhony")

    if (contaStephanie.transferencia(valor = 5.0, destino = contaJhony)) {
        println("Transferência sucedida")
    } else {
        println("Falha na transferência")
    }
    println("Verificando saldo após operação de transferência:")
    println("Saldo do Jhony: ${contaJhony.saldo}")
    println("Saldo da Stephanie: ${contaStephanie.saldo}")

}

class Conta(
    var titular: String,
    val numero: Int
) {
    var saldo = 0.0
        private set

    fun deposito(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    fun saque(valor: Double) {
        if (saldo >= valor) {
            this.saldo -= valor
        }
    }

    fun transferencia(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposito(valor)
            return true
        }
        return false
    }

    fun testaCopiaEReferencias() {

        val numeroX = 10
        var numeroY = numeroX
        numeroY++

        println(numeroX)
        println(numeroY)

        var contaJoao = Conta("João", 1002)
        var contaMaria = Conta("Maria", 1003)


        println("titular conta joao: ${contaJoao.titular}")
        println("titular conta maria: ${contaMaria.titular}")
        println(contaJoao)
        println(contaMaria)
    }

    fun testaCondicoes(saldo: Double) {
        //Estrutura condicional padrão
        if (saldo > 0.0) {
            println("saldo positivo")
        } else if (saldo == 0.0) {
            println("saldo neutro")
        } else
            println("saldo negativo")

        //Estrutura condicional Kotlin
        when {
            saldo > 0.0 -> println("saldo positivo")

            saldo == 0.0 -> println("saldo neutro")

            else -> println("saldo negativo")
        }
    }

    fun testaLaco() {
        var i = 0
        while (i < 10) {
            i++

            val titular: String = "Jhony $i"
            val numeroConta: Int = 1000 + i
            var saldo: Double = i + 10.0


            println("Titular: $titular")
            println("Conta: $numeroConta")
            println("Saldo: $saldo")
            println()
        }
        for (i in 5 downTo 1) {

            if (i == 4) {
                continue
            }

            val titular: String = "Jhony $i"
            val numeroConta: Int = 1000 + i
            var saldo: Double = i + 10.0


            println("Titular: $titular")
            println("Conta: $numeroConta")
            println("Saldo: $saldo")
            println()
        }

        for (i in 1..5){
            println("numero: $i")
        }
    }
}


