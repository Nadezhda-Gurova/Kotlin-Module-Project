package presenter

import navigation.Destination
import navigation.Screen
import storage.Storage
import view.View

class OpenArchivePresenter(
    private val storage: Storage,
    private val view: View
) : Presenter {

    override fun show(): Destination {
        while (true) {
            view.show(
                "Выберите архив по его номеру в списке: \n${
                    storage.getArchives().joinToString("\n")
                } \n" +
                        "или введите -1 для возвращения на экран архивов"
            )
            val input = view.input().toIntOrNull()
            if (input != null && input < storage.getArchives().size && input >= 0) {
                return Destination.OpenScreen(Screen.ArchiveScreen(storage.getArchive(input)))
            } else {
                if (input == -1) {
                    return Destination.Back
                } else {
                    view.show("Введите название архива")
                }
            }
        }
    }
}



