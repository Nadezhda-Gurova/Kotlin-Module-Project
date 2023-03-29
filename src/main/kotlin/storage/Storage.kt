package storage

interface Storage {
    fun addArchive(name: String)
    fun getArchives(): List<String>
    fun getArchive(index: Int): Archive
}