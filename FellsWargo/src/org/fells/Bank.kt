package org.fells

class Bank(var name: String, val description: String) {
    val customers: MutableCollection<User> = ArrayList()
    val employees: MutableCollection<User> = ArrayList()

    val accounts: MutableCollection<Account> = ArrayList()

    fun addUser(user: User) = if (user.type == UserType.CUSTOMER) customers.add(user) else employees.add(user)
}