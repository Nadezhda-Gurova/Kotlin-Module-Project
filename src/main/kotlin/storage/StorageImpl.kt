package storage

class StorageImpl : Storage {
    private val storage = mutableMapOf<String, Archive>()

    init {
        storage["arch1"] = Archive().apply {
            addNote("note1", "arch1: note1 content")
            addNote("note2", "arch1: note2 content")
            addNote("note3", "arch1: note3 content")
        }
        storage["arch2"] = Archive().apply {
            addNote("note4", "arch2: note4 content")
            addNote("note5", "arch2: note5 content")
            addNote("note6", "arch2: note6 content")
        }
    }

    override fun addArchive(name: String) {
        storage[name] = Archive()
    }

    override fun getArchives(): List<String> {
        return storage.keys.toList()
    }

    override fun getArchive(name: String): Archive {
        return storage[name]!!
    }


}