// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario (val nome: String, val email: String)

data class ConteudoEducacional(
    var nome: String, 
    var duracao: Int = 60, 
    var descricao: String = "",
    val nivel: Nivel = Nivel.BASICO

)

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)){
            inscritos.add(usuario)
            println("${usuario.nome} foi matriculado(a) na formação $nome.")
        } else {
            println("${usuario.nome} já está matriculado na formação $nome.")
        }

    }
    
    fun removerMatricula(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            inscritos.remove(usuario)
            println("Matricula de ${usuario.nome} na formação $nome foi cancelada.")
        } else {
            println("${usuario.nome} não está matriculado na formação $nome foi cancelada.")
        }
    }
    fun adicionarConteudoEducacional (conteudo: ConteudoEducacional) {
        if (!conteudos.contains(conteudo)) {
            conteudos.add(conteudo)
            println("O conteúdo ${conteudo.nome} foi adicionado à formação $nome.")
        } else {
            println("O conteúdo ${conteudo.nome} já pertence à formação $nome.")
        }
    }
    
    fun removerConteudoEducacional (conteudo: ConteudoEducacional) {
        if (conteudos.contains(conteudo)) {
            conteudos.add(conteudo)
            println("O conteúdo ${conteudo.nome} foi removido da formação $nome.")
        } else {
            println("O conteúdo ${conteudo.nome} não pertence à formação $nome.")
        }
    }
}

fun main() {
    val usuario1 = Usuario("Maria", "maria@example.com")
    val usuario2 = Usuario("Leo", "leo@example.com")

    val conteudo1 = ConteudoEducacional("Introdução à Programação", 60, "Fundamentos de programação", Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Algoritmos Avançados", 180, "Estudo de algoritmos avançados", Nivel.AVANCADO)

    val formacao = Formacao("Ciência da Computação")
    formacao.adicionarConteudoEducacional(conteudo1)
    formacao.adicionarConteudoEducacional(conteudo2)

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario1) // Tentando matricular o mesmo usuário novamente
    formacao.removerMatricula(usuario2)

}
