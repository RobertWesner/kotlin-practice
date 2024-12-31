package org.example

import org.example.apps.CLIApp
import org.example.apps.CatSay
import org.example.apps.TicTacToe
import java.io.IO.println

class App {
    val apps: Array<CLIApp>
        get() {
            return arrayOf(
                TicTacToe(),
                CatSay(),
            )
        }
}

fun main() {
    val apps = App().apps

    while (true) {
        println(
            apps
                .mapIndexed { i: Int, app: CLIApp -> (i + 1).toString() + ") " + app.name }
                .joinToString("\n")
        )
        println("e) Exit\n")

        print("> ")

        val raw = readln().split(" ")
        if (raw[0].lowercase() == "e") {
            break
        }

        val input = raw[0].toInt()
        if (input > apps.size) {
            continue
        }

        apps[input - 1].run(raw.slice(1 until raw.size))
    }
}
