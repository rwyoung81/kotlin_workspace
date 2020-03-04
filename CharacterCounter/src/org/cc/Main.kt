package org.cc

import java.io.File

fun main(args: Array<String>) {
    // first argument is the file path
    val path = args[0]
    var contents = ""
    var characterMap: MutableMap<Char, Int> = HashMap()
    var output = ""

    File(path).forEachLine { contents += it }

    for (char in contents) {
        var count: Int = characterMap.getOrDefault(char, 0)
        characterMap[char] = ++count
    }

    for (key in characterMap.keys) {
        output += "$key : ${characterMap[key].toString()}\n"
    }

    // output to a '.counts' file with the same name
    File("$path.counts").writeText(output)
}