package com.dagrigorev.bankapp.data.account

import java.time.Instant
import java.util.*

open class AccountListElement {
    private var name: String = "Saving"
    private var type: AccountType = AccountType.CardVisa
    private var number: Number = 60816923
    private var balance: Double = 28950.0
    private var currency: String = "$"
    private var lastOperationAt: Date = Date.from(Instant.now())
    private var isAccountActive: Boolean = false

    constructor(name: String, type: AccountType, number: Number,
                balance: Double, lastOperationAt: Date) {
        this.name = name
        this.type = type
        this.number = number
        this.balance = balance
        this.currency = currency
        this.lastOperationAt = lastOperationAt
        this.isAccountActive = true
    }

    fun getAccountName(): String {
        return this.name
    }

    fun getAccountType(): AccountType {
        return this.type
    }

    fun getAccountNumber(): Number {
        return this.number
    }

    fun getAccountBalance(): Double {
        return this.balance
    }

    /**
     * Updates account balance
     *
     * @throws IllegalArgumentException when newValue is negative
     */
    fun updateAccountBalance(newValue: Double) {
        if (newValue < 0)
            throw IllegalArgumentException("Balance value cannot be negative")
        this.balance = newValue
    }

    fun getCurrency(): String {
        return this.currency
    }

    fun getLastActivity(): Date {
        return this.lastOperationAt
    }

    /**
     * Updates activity time
     */
    fun saveActivityTime() {
        this.lastOperationAt = Date.from(Instant.now())
    }

    fun getAccountStatus(): Boolean {
        return this.isAccountActive
    }

    fun blockAccount() {
        this.isAccountActive = false
    }

    fun closeAccount() {
        this.isAccountActive = false
    }

    fun activateAccount() {
        this.isAccountActive = true
    }
}