
fun lernum(mensagem: String, valorpadrao: Double): Double{
    while (true){
        print(mensagem)

        val entrada = readlnOrNull()
        val numero = entrada?.toDoubleOrNull()

        if (entrada == null){
            println("Entrada encerrada. Usando o valor padrão.")
            return valorpadrao
        } else if (numero == null || !numero.isFinite()) {
            println("Erro! Digite um número válido.")
        } else if (numero < 0) {
            println("Erro! Não são permitidos valores negativos.")
        } else {
            return numero
        }
    }
}

fun leitributaria(imposto: Double): Boolean{
    val limitepermitido = 2000.0

    if (imposto > limitepermitido){
        println("\n====================================")
        println("        IMPEACHMENT APROVADO!")
        println("====================================")
        println("O imposto anual ultrapassou o limite permitido.")
        println(
                    "Devido a política de impostos abusivos " +
                    "uma revolta populacional foi gerada, " +
                    "resultado em Impeachment imediato."
        )
        println("Seu mandato foi encerrado antes de começar.")
        return true
    }

    return false
}

fun mostrarstatus(ano: Int, caixa: Double, aprovacao: Int){
    println()
    println("------- STATUS -------")
    println("Ano: $ano")
    println("Caixa: R$ %.2f".format(caixa))
    println("Aprovação: $aprovacao%")
    println("----------------------")
}

fun calcularresultados(
    imposto: Double,
    habitantes: Int,
    despesas: Double
): Double{

    val contribuintes = habitantes * 60 / 100
    val arrecadacao = imposto * contribuintes

    return arrecadacao - despesas
}

fun escolherpoliticas(): Int{
    while (true){
        println("\nEscolha uma política para esse ano:")
        println("1 - Saúde")
        println("2 - Educação")
        println("3 - Economia")
        println("4 - Infraestrutura")
        println("5 - Economizar recursos")

        print("Escolha: ")

        val escolha = readlnOrNull()?.toIntOrNull() ?: 0

        if (escolha in 1..5){
            return escolha
        }

        println("Opção inválida! Escolha um número de 1 a 5.")
    }
}

fun main() {

    println("===================================")
    println("       SIMULADOR DE PREFEITO")
    println("===================================")

    val imposto = lernum(
        "Digite o imposto anual do cidadão: ",
        1000.0
    )

    if (leitributaria(imposto)) {
        return
    }

    val caixainicial = 100000000.0

    var caixa = caixainicial
    var aprovacao = 50
    var mandatoInterrompido = false

    val habitantes = 2300000
    val despesasbase = 1800000000.0

    println("\nImposto definido: R$ %.2f".format(imposto))
    println("Caixa inicial: R$ %.2f".format(caixainicial))

    for (ano in 1..4) {

        println("\n========== ANO $ano ==========")

        var despesasano = despesasbase

        val politica = escolherpoliticas()

        when (politica) {

            1 -> {
                println("Você investiu em Saúde.")
                despesasano += 400000000.0
                aprovacao += 10
            }

            2 -> {
                println("Você investiu em Educação.")
                despesasano += 500000000.0
                aprovacao += 10
            }

            3 -> {
                println("Você investiu em Economia.")
                despesasano += 800000000.0
                aprovacao += 15
            }

            4 -> {
                println("Você investiu em Infraestrutura.")
                despesasano += 100000000.0
                aprovacao += 5
            }

            5 -> {
                println("Você decidiu economizar recursos.")
                despesasano -= 300000000.0
                aprovacao -= 10
            }
        }

        val resultado = calcularresultados(
            imposto,
            habitantes,
            despesasano
        )

        caixa += resultado

        println(
            "Resultado financeiro: R$ %.2f".format(resultado)
        )

        if (resultado >= 300000000.0) {
            aprovacao += 5
            println("A prefeitura apresentou um bom superávit.")

        } else if (resultado >= 0) {
            aprovacao += 2
            println("As contas públicas estão equilibradas.")

        } else if (resultado >= -300000000.0) {
            aprovacao -= 5
            println("A prefeitura apresentou déficit.")

        } else {
            aprovacao -= 15
            println("Crise financeira! O déficit foi muito elevado.")
        }

        when {
            imposto < 800.0 -> {
                aprovacao += 5
                println("A população aprovou os impostos baixos.")
            }

            imposto < 1200.0 -> {
                println("A carga tributária foi considerada aceitável.")
            }

            imposto < 1600.0 -> {
                aprovacao -= 5
                println("Parte da população reclama dos impostos.")
            }

            else -> {
                aprovacao -= 15
                println("Protestos contra os impostos elevados!")
            }
        }

        aprovacao = aprovacao.coerceIn(0, 100)


        val verbaemergencia = if (caixa > 0) {
            caixa * 10 / 100
        } else {
            0.0
        }

        println(
            "Reserva de emergência (10%%): R$ %.2f"
                .format(verbaemergencia)
        )

        if (ano % 2 == 0) {
            println("Revisão bienal das finanças realizada.")
        }

        if (caixa < -500000000.0) {
            println("\n====================================")
            println("       FALÊNCIA ADMINISTRATIVA!")
            println("====================================")
            println("A prefeitura acumulou dívidas insustentáveis.")
            println("Seu mandato foi encerrado no ano $ano.")

            mandatoInterrompido = true
            break
        }

        if (aprovacao < 30) {
            println("\n====================================")
            println("        IMPEACHMENT APROVADO!")
            println("====================================")
            println("Sua aprovação caiu abaixo de 30%.")
            println("Seu mandato foi encerrado no ano $ano.")

            mandatoInterrompido = true
            break
        }

        when {
            aprovacao >= 80 ->
                println("Aprovação excelente!")

            aprovacao >= 60 ->
                println("Aprovação boa.")

            aprovacao >= 40 ->
                println("Aprovação moderada.")

            else ->
                println("Aprovação baixa.")
        }

        if (caixa < 0 || aprovacao < 40) {
            println(
                "ALERTA: A prefeitura enfrenta dificuldades!"
            )
        }

        mostrarstatus(ano, caixa, aprovacao)

    }

    if (!mandatoInterrompido) {

        println("\n===========================")
        println("       FIM DO MANDATO")
        println("===========================")
        println("Você completou os 4 anos de mandato!")

        val reeleicao = aprovacao >= 60 && caixa >= 70000000.0

        if (reeleicao){
            println("Você atende aos requisitos para a reeleição!")
        } else{
            println(
                "Você não atingiu os requisitos para a reeleição."
            )
        }

    } else{
        println(
            "\nFim de jogo: mandato interrompido antes dos quatro anos."
        )
    }

}

