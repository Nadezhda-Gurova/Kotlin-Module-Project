package storage

class StorageImpl : Storage {
    private val storage = mutableListOf<Archive>()

    override fun addArchive(name: String) {
        storage.add(Archive(name))
    }

    override fun getArchives(): List<String> {
        return storage.mapIndexed { index, archive -> "$index - ${archive.name}" }
    }

    override fun getArchive(index: Int): Archive {
        return storage[index]
    }


}