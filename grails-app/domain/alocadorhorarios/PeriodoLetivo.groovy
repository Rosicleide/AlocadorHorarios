package alocadorhorarios

class PeriodoLetivo {

	Integer ano
	Integer numero

	static hasMany = [turmas:Turma]

    static constraints = {
		ano()
		numero(max:2, min:1)
    }
}