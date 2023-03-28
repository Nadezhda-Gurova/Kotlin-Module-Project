package presenter

import navigation.Destination
import navigation.Screen
import storage.Archive
import view.View

class OpenNotePresenter(
    private val archive: Archive,
    private val view: View
) : Presenter {

    private fun getNote(): Destination {
        while (true) {
            view.show("Введите индекс заметки или -1 для возврата на экран выбора архива")
            val noteIndex = view.input().toIntOrNull()
            if (noteIndex != null && noteIndex >= 0 && noteIndex < archive.getNotes().size) {
                return Destination.OpenScreen(Screen.ShowNoteScreen(archive.getNote(noteIndex)))
            }
            if (noteIndex == -1) {
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
            return getNote()
        }
    }
}