package navigation

import presenter.*
import storage.Storage
import view.View
import java.util.*
import kotlin.system.exitProcess

class NavigationImpl(
    private val storage: Storage,
    private val view: View,
) : Navigation {

    private val stack = Stack<Presenter>()

    private fun exit() {
        exitProcess(0)
    }

    private fun back() {
        stack.pop()
        navigate(stack.peek().show())
    }

    private fun addToStackAndStart(presenter: Presenter) {
        stack.push(presenter)
        navigate(presenter.show())
    }

    override fun navigate(destination: Destination) {
        when (destination) {
            Destination.Back -> back()
            Destination.Exit -> exit()
            is Destination.OpenScreen -> openScreen(destination.screen)
        }
    }

    private fun openScreen(screen: Screen) {
        when (screen) {
            Screen.ArchivesScreen -> addToStackAndStart(
                ArchivesPresenter(view)
            )
            Screen.CreateArchiveScreen -> addToStackAndStart(
                CreateArchivePresenter(storage, view)
            )
            Screen.OpenArchiveScreen -> addToStackAndStart(
                OpenArchivePresenter(storage, view)
            )
            is Screen.CreateNoteScreen -> {
                stack.push(
                    OpenNotePresenter(screen.archive, view)
                )
                addToStackAndStart(
                CreateNotePresenter(screen.archive, view)
            )
            }
            is Screen.OpenNoteScreen -> addToStackAndStart(
                OpenNotePresenter(screen.archive, view)
            )
            is Screen.ShowNoteScreen -> addToStackAndStart(
                ShowNotePresenter(screen.note, view)
            )
        }
    }
}