enum class Nivel {Básico, Intermediário, Avançado}

data class Usuario(val nome: String, val email: String, val tipoUsuario: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun imprimirListaInscritos(){
        for(user in inscritos){
            println(user.nome)
        }
    }
    
    fun imprimirGradeFormacao(){
        for(cont in conteudos){
            println("${cont.nome} - ${cont.duracao}")
        }
    }
}

fun main() {
    
    val moduloFlutter = ConteudoEducacional("Curso de Flutter", 80, Nivel.Intermediário)
    val moduloKotlin = ConteudoEducacional("Curso de Kotlin", 60, Nivel.Intermediário)
    val moduloIOS = ConteudoEducacional("Curso de Swift", 80, Nivel.Avançado)
    
    val listConteudos = mutableListOf<ConteudoEducacional>()
    listConteudos.add(moduloFlutter)
    listConteudos.add(moduloKotlin)
    listConteudos.add(moduloIOS)
    
    val formacaoAndroid = Formacao("Formação Mobile Master", listConteudos, Nivel.Avançado)
    
    val Fulano = Usuario("Fulano", "fulano@mail.com", "premium")
    val Beltrano = Usuario("Beltrano", "beltrano@mail.com", "premium")
    val Cicrano = Usuario("Cicrano", "cicrano@mail.com", "free")
    
    formacaoAndroid.matricular(Fulano)
    formacaoAndroid.matricular(Beltrano)
    
    print("Formação: ")
    println("${formacaoAndroid.nome} - ${formacaoAndroid.nivel}")
    println("Syllabus: ")
    println(formacaoAndroid.imprimirGradeFormacao())
    println()
    println("Lista de inscritos aceitos: ")
    println(formacaoAndroid.imprimirListaInscritos())
}
