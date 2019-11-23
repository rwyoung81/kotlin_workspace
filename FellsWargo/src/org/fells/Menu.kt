package org.fells

class Menu(private val title: String) {
    val options: MutableMap<Action, () -> Boolean> = HashMap()
    var back: Menu? = null

    constructor(title: String, back: Menu) : this(title) {
        this.back = back
    }

    // Add a link to another menu
    fun linkMenu(key: String, menu: Menu) {
        options[Action(key, "Load ${menu.title}") { menu.load() }] = { true }
    }

    // Display the menu and accept user input, and returns true if we're done
    fun load() : Boolean {
        println("----------------- $title -----------------")

        for (action in options.keys) {
            val predicate: (() -> Boolean)? = options[action]
            if (predicate != null && predicate()) {
                println("[${action.key}]: ${action.description}")
            }
        }

        println("Please choose an option above:")

        var done : Boolean = false

        readLine()?.let {
            when {
                it.trim() == "back" -> back?.load()
                it.trim() == "exit" -> {
                    println("Exiting application")
                    done = true
                }
                else -> for (action in options.keys) {
                    if (action.key == it.trim()) {
                        done = action.select()
                    }
                }
            }
        }

        return done
    }
}