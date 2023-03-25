import presenter.*
import storage.Archive
import storage.Note
import storage.Storage
import view.ConsoleView
import java.util.Stack
import kotlin.system.exitProcess

class NavigationImpl(
    private val storage: Storage
) : Navigation {

    private val stack = Stack<Presenter>()

    override fun archives() {
        val archivesScreen = ArchivesPresenter(this, ConsoleView())
        stack.push(archivesScreen)
        archivesScreen.start()
    }

    override fun createArchive() {
        val createArchiveScreen = CreateArchivePresenter(this, storage, ConsoleView())
        stack.push(createArchiveScreen)
        createArchiveScreen.start()
    }

    override fun openArchive() {
        val open = OpenArchivePresenter(this, storage, ConsoleView())
        stack.push(open)
        open.start()
    }

    override fun exit() {
        exitProcess(0)
    }

    override fun createNote(archive: Archive) {
        val createNotePresenter = CreateNotePresenter(this, archive, ConsoleView())
        stack.push(createNotePresenter)
        createNotePresenter.start()
    }

    override fun openNote(archive: Archive) {
        val presenter = OpenNotePresenter(this, archive, ConsoleView())
        stack.push(presenter)
        presenter.start()
    }

    override fun showNote(note: Note) {
        val presenter = ShowNotePresenter(this, note, ConsoleView())
        stack.push(presenter)
        presenter.start()
    }

    override fun back() {
        stack.pop()
        stack.peek().start()
    }
}