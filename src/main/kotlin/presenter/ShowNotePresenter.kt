package presenter

import Navigation
import storage.Note
import view.View

class ShowNotePresenter(
    private val navigation: Navigation,
    private val note: Note,
    private val view: View
) : AbstractPresenter() {
    override fun loop() {
        view.show("Содержимое заметки")
        view.show(note.content)
        while (true) {
            view.show("Введите 0, чтобы вернуться на экран просмотра архива")
            if (view.input() == "0") {
                stop()
                navigation.back()
            }
        }
    }
}