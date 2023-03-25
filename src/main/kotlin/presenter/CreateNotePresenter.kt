package presenter

import Navigation
import storage.Archive
import view.ConsoleView

class CreateNotePresenter(
    private val navigation: Navigation,
    private val storage: Archive,
    private val view: ConsoleView
) : AbstractPresenter() {
    override fun loop() {
        view.show("Создайте название заметки")
        val noteName = view.input()
        if (noteName.isNotEmpty()) {
            view.show("Введите текст заметки")
            val noteText = view.input()
            storage.addNote(noteName, noteText)
            stop()
            navigation.back()
        } else {
            view.show("Введите название заметки")
        }
    }
}