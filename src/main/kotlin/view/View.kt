package view

interface View {
    fun show(content: String)
    fun input(): String
}