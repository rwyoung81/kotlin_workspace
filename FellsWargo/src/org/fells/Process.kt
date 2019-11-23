package org.fells

// Represents a multi-step process. Consists of a list of inputs to read one-after-another,
// does some processing on the inputs, and returns the results.
abstract class Process<T>(val name: String, private val inputNames: List<String>) {
    protected val inputs: MutableMap<String, String> = LinkedHashMap()

    abstract fun getResult() : T

    fun start() {
        println("Enter values for $name:")

        for (inputName in inputNames) {
            println("$inputName: ")
            readLine()?.let {
                inputs[inputName] = it.trim()
            }
        }
    }
}