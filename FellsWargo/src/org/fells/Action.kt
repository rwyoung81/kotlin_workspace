package org.fells

data class Action(val key: String, val description: String, val select: () -> Boolean)