package storage

class StorageImpl : Storage {
    private val storage = mutableMapOf<String, Archive>()

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