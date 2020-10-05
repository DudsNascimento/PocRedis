package com.sample;

import io.javalin.http.Context
import com.google.inject.Guice
import com.google.inject.AbstractModule
import javax.inject.Inject
import javax.inject.Singleton
import org.slf4j.LoggerFactory
import org.litote.kmongo.*
import com.mongodb.client.MongoDatabase;
import com.fasterxml.jackson.databind.ObjectMapper;

class MongoRepositoryModule : AbstractModule() {
    
    override fun configure() {
        bind(MongoRepository::class.java).to(MongoRepositoryImpl::class.java)
    }
}

interface MongoRepository {
    fun salvar(aluno: Aluno)
}

@Singleton
class MongoRepositoryImpl : MongoRepository {

    val database: MongoDatabase

    @Inject
    constructor() {

        database = KMongo.createClient("mongodb://admin:122333@localhost:27017").getDatabase("teste")
    }

    override fun salvar(aluno: Aluno) {
        val collection = database.getCollection<Aluno>()
        collection.insertOne(aluno)
    }
}