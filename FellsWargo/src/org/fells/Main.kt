package org.fells

val bank = Bank("Fells Wargo", "Lorem ipsum dolor sit amet...")
val admin = User("admin", "admin@fells.com", "passw0rd", UserType.ADMIN)
var currentUser = User("guest", "guest@fells.com","passw0rd", UserType.CUSTOMER)

fun main() {

    val mainMenu = Menu("Main Menu").apply {
        Action("info", "View bank offerings") {
            println(bank.description)
            false
        }.let { options[it] = { true /* always show this */ } }

        Action("signup", "Create an account with us") {
            createAccountProcess.start()
            bank.addUser(createAccountProcess.getResult())
            false
        }.let { options[it] = { currentUser.username == "guest" || currentUser == admin } }

        Action("login", "Log into your account") {
            loginProcess.start()
            currentUser = loginProcess.getResult()
            false
        }.let { options[it] = { currentUser.username == "guest" || currentUser == admin } }
    }

    var done = false

    do {
        println()
        println("[Current user: ${currentUser.username}]")

        done = mainMenu.load()
    } while (!done)

    println("Done!")
}

val createAccountProcess = object: Process<User>("Sign up", listOf("username", "email", "password")) {
    override fun getResult() : User {
        val username = this.inputs["username"] ?: ""
        val email = this.inputs["email"] ?: ""
        val password = this.inputs["password"] ?: ""

        return User(username, email, password, UserType.CUSTOMER)
    }
}

val loginProcess = object: Process<User>("Log in", listOf("username", "password")) {
    override fun getResult(): User {
        val username = this.inputs["username"] ?: ""
        val password = this.inputs["password"] ?: ""

        if (username == admin.username && password == admin.password) return admin

        for (user in bank.customers) {
            if (user.username == username && user.password == password) return user
        }

        throw IllegalArgumentException("User not found!")
    }
}