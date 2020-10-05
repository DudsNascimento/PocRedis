package com.sample;

import io.javalin.http.Context
import com.google.inject.Guice
import com.google.inject.AbstractModule
import javax.inject.Inject
import javax.inject.Singleton

class LoanControllerModule : AbstractModule() {
    
    override fun configure() {
        bind(LoanController::class.java).to(LoanControllerImpl::class.java)
        install(LoanServiceModule())
    }
}

interface LoanController {
    fun calculate(ctx: Context, loan: Loan?)
}

@Singleton
class LoanControllerImpl : LoanController {

    var loanService: LoanService

    @Inject
    constructor(loanService: LoanService) {
        this.loanService = loanService
    }

    override fun calculate(ctx: Context, loan: Loan?) {
        loan?.let {
            ctx.json(loanService.calculate(it))
        }
    }
}