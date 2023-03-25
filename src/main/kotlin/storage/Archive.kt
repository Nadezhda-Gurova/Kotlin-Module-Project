package storage

class Archive {

    private val notesStorage = mutableMapOf<String, Note>()

    fun addNote(name: String, content: String) {
        notesStorage[name] = Note(content)
    }

    fun getNotes(): List<String> {
        return notesStorage.keys.toList()
    }

    fun getNote(name: String): Note {
        return notesStorage[name]!!
    }
}