package storage

interface Storage {
    fun addArchive(name: String)
    fun getArchives(): List<String>
    fun getArchive(name: String): Archive
}