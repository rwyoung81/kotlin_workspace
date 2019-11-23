package org.fells

class Account(val owner: User) {
    var balance: Double = 0.0
    val transactions: MutableCollection<Transaction> = ArrayList()

    fun addTransaction(transaction: Transaction) {
        when (transaction.type) {
            TransactionType.ADD -> balance += transaction.amount
            TransactionType.REMOVE -> balance -= transaction.amount
        }

        transactions.add(transaction)
    }
}