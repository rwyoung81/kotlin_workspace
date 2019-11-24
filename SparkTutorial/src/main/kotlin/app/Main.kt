package app

import spark.Spark.*

fun main(args: Array<String>) {
    port(8080)
    get("/hello") { request, response ->
        "Hi World"
    }
}