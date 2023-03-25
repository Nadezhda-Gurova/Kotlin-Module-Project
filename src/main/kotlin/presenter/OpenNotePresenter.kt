package presenter

import Navigation
import storage.Archive
import view.ConsoleView

class OpenNotePresenter(
    private val navigation: Navigation,
    private val archive: Archive,
    private val view: ConsoleView
) : AbstractPresenter()  {
    override fun loop() {
        view.show("В этом архиве у вас есть следующие заметки:")
        val allNotes = archive.getNotes()
        for (note in allNotes){
            view.show(note)
        }
        getNote(allNotes)
    }

    private fun getNote(allNotes: List<String>) {
        while (true) {
            view.show("Введите название заметки или 0 для возврата на предыдущий экран")
            val noteName = view.input()
            if (noteName in allNotes) {
                stop()
                return navigation.showNote(archive.getNote(noteName))
            }
            if (noteName == "0"){
                stop()
                return navigation.back()
            }
        }
    }
}