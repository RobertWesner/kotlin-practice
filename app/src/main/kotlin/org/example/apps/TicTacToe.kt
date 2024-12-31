package org.example.apps

class TicTacToe : CLIApp() {
    override val name: String = "TicTacToe"

    override fun run(args: List<String>) {
        var board = Array(9) { _ -> 0 }

        for (row in board.toList().chunked(3)) {
            println("+---+---+---+")
            println("| " + row.map { i -> charArrayOf(' ', 'X', '0')[i] }.joinToString(" | ") + " |")
        }
        println("+---+---+---+")
    }
}
