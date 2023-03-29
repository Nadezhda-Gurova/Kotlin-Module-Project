package navigation

import storage.Archive
import storage.Note

sealed class Screen {
    object ArchivesScreen : Screen()
    object CreateArchiveScreen : Screen()
    class ArchiveScreen(val archive: Archive) : Screen()
    class CreateNoteScreen(val archive: Archive) : Screen()
    object OpenArchiveScreen : Screen()
    class OpenNoteScreen(val archive: Archive) : Screen()
    class ShowNoteScreen(val note: Note) : Screen()
}