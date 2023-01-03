package com.dagrigorev.bankapp.data.credit

import com.dagrigorev.bankapp.data.account.AccountListElement
import com.dagrigorev.bankapp.data.account.AccountType
import java.util.*

class CreditListElement(
    name: String,
    type: AccountType,
    number: Number,
    balance: Double,
    lastOperationAt: Date,
    creditType: CreditType
) : AccountListElement(name, type, number, balance, lastOperationAt) {
    private var loanAmount: Double = balance
    private var creditType: CreditType = creditType

    fun getLoanAmount(): Double {
        return this.loanAmount;
    }

    fun getCreditType(): CreditType {
        return this.creditType
    }
}