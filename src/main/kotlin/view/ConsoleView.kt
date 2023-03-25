package view

import java.util.Scanner

class ConsoleView: View {

    private val scanner = Scanner(System.`in`)

    override fun show(content: String){
        println(content)
    }

    override fun input(): String {
        return scanner.nextLine().trim()
    }

}