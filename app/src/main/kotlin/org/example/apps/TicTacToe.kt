package org.example.apps

class TicTacToe : CLIApp() {
    override val name: String = "TicTacToe"

    private fun getPlayer(player: Int) : Char {
        return charArrayOf(' ', 'X', 'O')[player];
    }

    private fun render(board: IntArray) {
        println("    1   2   3")
        for ((c, row) in board.toList().chunked(3).withIndex()) {
            println("  +---+---+---+")
            println(row.map { getPlayer(it) }.joinToString(" | ", (c + 65).toChar() + " | ", " |"))

        }
        println("  +---+---+---+")
    }

    private fun check(board: IntArray) : Int {
        val win = arrayOf("111", "222")

        val diagonals = arrayOf(
            board.slice(0..8 step 4).joinToString(""),
            board.slice(2..6 step 2).joinToString(""),
        )
        for (diagonal in diagonals) {
            if (diagonal in win) {
                return board[4]
            }
        }

        for (i in 0..2) {
            if (
                board.slice((i * 3)..(i * 3 + 2)).joinToString("") in arrayOf("111", "222")
                    || board.slice(i..(i + 6) step 3).joinToString("") in arrayOf("111", "222")
            ) {
                return board[i]
            }
        }

        return 0
    }

    override fun run(args: List<String>) {
        val board = IntArray(9) { _ -> 0 }
        var currentPlayer = 1

        var i = 0
        while (true) {
            render(board)

            if (i >= 9) {
                println("It's a draw!\n")

                return
            }

            println("Player: " + getPlayer(currentPlayer))

            while (true) {
                print("> ")
                val input = readln().take(2).toCharArray()
                input[0] = input[0].uppercaseChar()

                if (
                    input[0] !in charArrayOf('A', 'B', 'C')
                        || input[1] !in charArrayOf('1', '2', '3')
                ) {
                    continue
                }

                val index = (input[0].code - 65) * 3 + input[1].digitToInt() - 1
                if (board[index] != 0) {
                    println("Already taken!")

                    continue
                }

                board[index] = currentPlayer

                break
            }

            when (check(board)) {
                1, 2 -> {
                    render(board)
                    println("Player " + getPlayer(currentPlayer) + " won!\n")

                    return
                }
            }

            currentPlayer = if (currentPlayer == 1) 2 else 1
            i++
        }
    }
}
