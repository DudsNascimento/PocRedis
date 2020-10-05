package com.sample;

import java.math.BigDecimal
import io.javalin.http.Context
import com.google.inject.Guice
import com.google.inject.AbstractModule
import javax.inject.Inject
import javax.inject.Singleton

class LoanServiceModule : AbstractModule() {
    
    override fun configure() {
        bind(LoanService::class.java).to(LoanServiceImpl::class.java)
        install(RedisRepositoryModule())
        install(MongoRepositoryModule())
    }
}

interface LoanService {
    fun calculate(loan: Loan): Loan
}

@Singleton
class LoanServiceImpl : LoanService {

    var redisRepository: RedisRepository
    var mongoRepository: MongoRepository

    @Inject
    constructor(redisRepository: RedisRepository,
        mongoRepository: MongoRepository) {

        this.redisRepository = redisRepository
        this.mongoRepository = mongoRepository
    }

    override fun calculate(loan: Loan): Loan {
        val loan: Loan = calculateLoanInstallments(loan, BigDecimal(0.045) withScale 2)
        this.redisRepository.salvar(loan)
        return loan
    }
}