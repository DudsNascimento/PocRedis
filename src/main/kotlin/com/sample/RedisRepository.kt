package com.sample;

import io.javalin.http.Context
import com.google.inject.Guice
import com.google.inject.AbstractModule
import javax.inject.Inject
import javax.inject.Singleton
import org.slf4j.LoggerFactory
import io.vertx.redis.client.Redis
import io.vertx.redis.client.RedisAPI
import io.vertx.core.Vertx;
import com.fasterxml.jackson.databind.ObjectMapper;

class RedisRepositoryModule : AbstractModule() {
    
    override fun configure() {
        bind(RedisRepository::class.java).to(RedisRepositoryImpl::class.java)
    }
}

interface RedisRepository {
    //fun salvar(aluno: Aluno)
    fun salvar(objeto: Any)
}

@Singleton
class RedisRepositoryImpl : RedisRepository {

    val redis: RedisAPI;
    val logger = LoggerFactory.getLogger("com.sample")
    val mapper = ObjectMapper()

    @Inject
    constructor() {

        val client = Redis.createClient(Vertx.vertx(), "redis://localhost:6379/1").connect({ onConnect ->
            if (onConnect.succeeded()) {
                logger.info("Conectou ao banco redis")
                var client = onConnect.result()
            }
        })
        redis = RedisAPI.api(client)
    }

    /*override fun salvar(aluno: Aluno) {
        var alunoJson: String = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(aluno)
        redis.rpush(listOf(aluno.getClass().simpleName, alunoJson), { res ->
            if (res.succeeded()) {
                logger.info("Aluno salvo com sucesso")
            }
        })
    }*/

    override fun salvar(objeto: Any) {
        var objetoJson: String = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objeto)
        redis.rpush(listOf(objeto.getClass().simpleName, objetoJson), { res ->
            if (res.succeeded()) {
                logger.info("${objeto.getClass().simpleName} salvo com sucesso")
            }
        })
    }
}