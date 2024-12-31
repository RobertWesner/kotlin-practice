package org.example.apps

abstract class CLIApp {
    abstract val name: String

    abstract fun run(args: List<String>)
}
