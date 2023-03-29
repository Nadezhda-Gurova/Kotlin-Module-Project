package presenter

import navigation.Destination
import storage.Archive
import view.View

class CreateNotePresenter(
    private val storage: Archive,
    private val view: View
) : Presenter {


    override fun show(): Destination {
        while (true) {
            view.show("Создайте название заметки")
            val input = view.input()
            if (input.isNotEmpty() && input != "0") {
                view.show("Введите текст заметки")
                val noteText = view.input()
                storage.addNote(input, noteText)
                while (true) {
                    view.show("Введите 0, чтобы вернуться на экран просмотра архива")
                    if (view.input() == "0") {
                        return Destination.Back
                    }
                }
            } else {
                if (input == "0") {
                    return Destination.Back
                } else {
                    view.show("Введите название заметки")
                }
            }
        }
    }
}