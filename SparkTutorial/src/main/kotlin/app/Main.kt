package app

import spark.Spark.*

fun main(args: Array<String>) {
    port(8080)
    post("/hello") { request, response ->
        val a : String? = request.queryParams("a")
        val b : String? = request.params("b")
        "Hi World [POST]"
    }

    get("/hello") { request, response ->
        val a : String? = request.queryParams("a")
        "Hi World [GET]"
    }
}