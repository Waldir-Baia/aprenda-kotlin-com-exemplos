// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(private val nome: String, private val idade: Int, private val email: String) {
    var formacaoEscolhida: Formacao? = null
    var conteudoEscolhido: ConteudoEducacional? = null

    fun exibirInformacoes() {
        println("Nome: $nome")
        println("Idade: $idade")
        println("Email: $email")
        formacaoEscolhida?.let {
            println("Formação Escolhida: ${it.nome}")
            conteudoEscolhido?.let { conteudo ->
                println("Conteúdo Escolhido: ${conteudo.nome}, Duração: ${conteudo.duracao} horas, Nível: ${conteudo.nivel}")
            } ?: println("Conteúdo não escolhido ainda")
        }
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int,  val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val conteudoKotlin = ConteudoEducacional("Kotlin Básico", 10, Nivel.BASICO)
    val conteudoJava = ConteudoEducacional("Java Intermediário", 15, Nivel.INTERMEDIARIO)
    val conteudoFlutter = ConteudoEducacional("Flutter Avançado", 25, Nivel.DIFICIL)

    val formacaoProgramacao = Formacao("Programação ", listOf(conteudoKotlin, conteudoJava, conteudoFlutter))

    val usuario1 = Usuario("Alice", 25, "alice@example.com")
    val usuario2 = Usuario("Bob", 30, "bob@example.com")
    val usuario3 = Usuario("Waldir Baia", 23, "walbaiaa18@gmail.com")

    formacaoProgramacao.matricular(usuario1)
    formacaoProgramacao.matricular(usuario2)
    formacaoProgramacao.matricular(usuario3)

    usuario1.formacaoEscolhida = formacaoProgramacao
    usuario1.conteudoEscolhido = conteudoKotlin

    usuario2.formacaoEscolhida = formacaoProgramacao
    usuario2.conteudoEscolhido = conteudoJava

    usuario3.formacaoEscolhida = formacaoProgramacao
    usuario3.conteudoEscolhido = conteudoFlutter

    usuario1.exibirInformacoes()
    usuario2.exibirInformacoes()
    usuario3.exibirInformacoes()
}