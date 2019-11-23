class Foo(val one: String, var two: String) {
    var test: String = ""
    set(value) {
        if (value != "") field = value
    }
}

fun main() {
    var foo = Foo("1", "2")
    foo.two = ""
    println("Foo.one is ${foo.one}")

    caller(5) { first: String, second: String -> println("1st: "); println("$first $second"); Unit }

    caller(4) { one: String, two: String -> print("2nd: "); print(one); print(two) }

    var aFunction: (String, String) -> Unit = fun(a: String, b: String) {}

    println("a, b, or c?")
    val choice = readLine()

    if (choice == "a") {
        aFunction = fun(c: String, d: String) {
            println("you chose a! : ")
            println(c)
            println(d)
        }
    }
    else if (choice == "b") {
        aFunction = fun(a: String, b: String) {
            println("you chose b! : ")
            print(a)
            print(b)
        }
    }
    else if (choice == "c") {
        aFunction = ::bFunction
    }

    println()
    caller(3, aFunction)
}

fun bFunction(first: String, second: String) {
    println("I'm ignoring the parameters.")
}

fun caller(times: Int = 10, func: (String, String) -> Unit) {
    for (i in 1..times) {
        func(i.toString(), " times!")
    }
}

fun sayStart(): Unit = println("start!")

fun repeat(message: String, times: Int) {
    var limit = message.length;
    if (message.length > limit) {
        limit = message.length
    }
    for (i in 0..limit) println(message + " " + message[i])
}