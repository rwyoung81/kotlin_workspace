package org.fells

enum class UserType {
    CUSTOMER, ADMIN
}

data class User(var username: String, var email: String, val password: String, var type: UserType)