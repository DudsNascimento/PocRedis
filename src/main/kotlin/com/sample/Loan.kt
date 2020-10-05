package com.sample

import java.util.Date
import java.math.BigDecimal
import java.math.RoundingMode

class BalanceDue(var age: BigDecimal,
    var gender: String,
    var balanceDue: BigDecimal,
    var balanceDueNumber: Int
) {}

class Loan(var clientId: String,
    var operationType: String,
    var gender: String,
    var birthdate: Date,
    var totalBalanceDue: BigDecimal,
    var totalBalanceDueList: Int,
    var balanceDueList: MutableList<BalanceDue>) {

    fun newBalanceDueList(initialBalanceDue: BigDecimal, monthlyTax: BigDecimal) {

        val today: Date = Date();
        var remainingTotalBalanceDue = this.totalBalanceDue
        var powMonthlyTax: BigDecimal = BigDecimal(1)
        this.balanceDueList = mutableListOf<BalanceDue>()
        for (i in 0 until totalBalanceDueList) {
            val months: BigDecimal = BigDecimal(getMonthsBetweenDates(this.birthdate, addMonths(today, i+1))) withScale 2
            var balanceDue: BalanceDue = BalanceDue(months / (BigDecimal(12) withScale 2),
                this.gender,
                remainingTotalBalanceDue withScale 2,
                i)
            remainingTotalBalanceDue -= initialBalanceDue*powMonthlyTax
            powMonthlyTax *= monthlyTax
            this.balanceDueList.add(balanceDue)
        }
    }
}