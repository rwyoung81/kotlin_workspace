package org.huffman

open class Node(var weight: Int = 0)

class Inner(weight: Int = 0, var left: Node, var right: Node) : Node(weight)

class Leaf(weight: Int = 0, var character: Character) : Node(weight)