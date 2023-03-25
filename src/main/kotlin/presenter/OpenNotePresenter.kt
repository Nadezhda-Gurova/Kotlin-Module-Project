package presenter

import navigation.Destination
import navigation.Screen
import storage.Archive
import view.View

class OpenNotePresenter(
    private val archive: Archive,
    private val view: View
) : Presenter {

    private fun getNote(allNotes: List<String>): Destination {
        while (true) {
            view.show("Введите название заметки или 0 для возврата на экран выбора архива")
            val noteName = view.input()
            if (noteName in allNotes) {
                return Destination.OpenScreen(Screen.ShowNoteScreen(archive.getNote(noteName)))
            }
            if (noteName == "0") {
                return Destination.Back
            }
        }
    }

    override fun show(): Destination {
        while (true) {
            view.show("В этом архиве у вас есть следующие заметки:")
            val allNotes = archive.getNotes()
            for (note in allNotes) {
                view.show(note)
            }
            return getNote(allNotes)
        }
    }
}