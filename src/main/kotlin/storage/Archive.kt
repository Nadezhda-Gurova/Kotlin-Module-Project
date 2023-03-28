package storage

class Archive(val name: String) {
    private val notesStorage = mutableListOf<Note>()

    fun addNote(name: String, content: String) {
        notesStorage.add(Note(name, content))
    }

    fun getNotes(): List<String> {
        return notesStorage.mapIndexed { index, note -> "$index - ${note.name}" }
    }

    fun getNote(index: Int): Note {
        return notesStorage[index]
    }
}