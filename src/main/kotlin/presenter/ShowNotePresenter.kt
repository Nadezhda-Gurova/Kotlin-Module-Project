package presenter

import navigation.Destination
import storage.Note
import view.View

class ShowNotePresenter(
    private val note: Note,
    private val view: View
) : Presenter {

    override fun show(): Destination {
        while (true) {
            view.show("Содержимое заметки")
            view.show(note.content)
            while (true) {
                view.show("Введите 0, чтобы вернуться на экран просмотра архива")
                if (view.input() == "0") {
                    return Destination.Back
                }
            }
        }
    }
}