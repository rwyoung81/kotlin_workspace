package app

import spark.Spark.*

fun main(args: Array<String>) {
    get("/hello:arg") { request, response ->
        "Hi World"
    }
}