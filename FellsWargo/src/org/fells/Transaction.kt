package org.fells

enum class TransactionType {
    ADD, REMOVE
}

data class Transaction(val type: TransactionType, val amount: Double)