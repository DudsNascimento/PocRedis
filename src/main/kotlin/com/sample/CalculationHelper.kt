package com.sample

import java.math.BigDecimal
import java.math.RoundingMode
import org.slf4j.LoggerFactory

fun calculateLoanInstallments(loan: Loan, monthlyTax: BigDecimal): Loan {

    val initialBalanceDue = calculateInitialBalanceDue(0,
        loan.totalBalanceDueList,
        loan.totalBalanceDue,
        BigDecimal(1)+monthlyTax,
        BigDecimal(1)+monthlyTax,
        BigDecimal(1));

    loan.newBalanceDueList(initialBalanceDue, BigDecimal(1)+monthlyTax)
    return loan
}

private fun calculateInitialBalanceDue(installment: Int,
    totalInstallments: Int,
    totalBalanceDue: BigDecimal,
    monthlyTax: BigDecimal,
    powMonthlyTax: BigDecimal,
    currentTax: BigDecimal): BigDecimal {

    if(installment < totalInstallments-1) {
 
        return calculateInitialBalanceDue(installment+1,
            totalInstallments,
            totalBalanceDue,
            monthlyTax,
            powMonthlyTax*monthlyTax,
            currentTax + powMonthlyTax)
    } else {

        return totalBalanceDue / currentTax;
    }
}