package com.sample;

import io.javalin.http.Context
import com.google.inject.Guice
import com.google.inject.AbstractModule
import javax.inject.Inject
import javax.inject.Singleton

class AlunoControllerModule : AbstractModule() {
    
    override fun configure() {
        bind(AlunoController::class.java).to(AlunoControllerImpl::class.java)
        install(ListaInicialAlunosModule())
        install(RedisRepositoryModule())
        install(MongoRepositoryModule())
    }
}

interface AlunoController {
    fun obterTodos(ctx: Context)
    fun obterTodosAlunos(): MutableList<Aluno>
    fun salvar(aluno: Aluno?)
}

@Singleton
class AlunoControllerImpl : AlunoController {

    var listaInicialAlunos: ListaInicialAlunos
    var redisRepository: RedisRepository
    var mongoRepository: MongoRepository

    @Inject
    constructor(listaInicialAlunos: ListaInicialAlunos,
        redisRepository: RedisRepository,
        mongoRepository: MongoRepository) {
        this.listaInicialAlunos = listaInicialAlunos
        this.redisRepository = redisRepository
        this.mongoRepository = mongoRepository
    }

    override fun obterTodos(ctx: Context) {
        ctx.json(listaInicialAlunos.alunos)
    }

    override fun salvar(aluno: Aluno?) {
        aluno?.let {
            //redisRepository.salvar(it)
            mongoRepository.salvar(it)
        }
    }

    override fun obterTodosAlunos(): MutableList<Aluno> {
        return listaInicialAlunos.alunos
    }
}