package org.example.apps

import kotlin.math.max

class CatSay : CLIApp() {
    override val name: String = "CatSay"

    override fun run(args: List<String>) {
        val text = args
            .joinToString(" ")
            .replace("\\n", "\n")
            .split("\n")

        val maxLength = max(text.maxOf { it.length }, 24)

        println("." + "-".repeat(maxLength + 2) + ".")
        println(text.joinToString(" |\n| ", "| ", " |") { it.padEnd(maxLength, ' ') })
        println("'---," + "-".repeat(maxLength - 2) + "'")
        println("    " + """
            |
             \   /\__/\    \\
                (' . ' )___//
                 | _  ____ |
                 || ||  ||||
        """.trimIndent().split("\n").joinToString("\n    "))
    }
}
