import storage.Archive
import storage.Note

interface Navigation {
    fun archives()
    fun createArchive()
    fun openArchive()
    fun exit()
    fun showNote(note: Note)
    fun back()
    fun createNote(archive: Archive)
    fun openNote(archive: Archive)
}




