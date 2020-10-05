package com.sample;

import com.google.inject.Guice;
import com.google.inject.AbstractModule;
import javax.inject.Inject;
import javax.inject.Singleton;

class ListaInicialAlunosModule : AbstractModule() {
    
    override fun configure() {
        bind(ListaInicialAlunos::class.java)
    }
}

class Aluno(

    var nome: String,
    var idade: Int,
    var codigo: String?) {
}

@Singleton
class ListaInicialAlunos {

    var alunos: MutableList<Aluno>

    @Inject
    constructor() {
        this.alunos = mutableListOf(Aluno("Tiago", 30, "111"),
        Aluno("Taynara", 32, "222"),
        Aluno("Florzinha", 40, null))
    }
}