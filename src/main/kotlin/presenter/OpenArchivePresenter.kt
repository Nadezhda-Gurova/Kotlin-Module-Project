package presenter

import navigation.Destination
import navigation.Screen
import storage.Storage
import view.View

class OpenArchivePresenter(
    private val storage: Storage,
    private val view: View
) : Presenter {

    private fun nextStep(archiveNumber: Int): Destination {
        while (true) {
            when (view.input()) {
                "0" -> {
                    return Destination.OpenScreen(
                        Screen.CreateNoteScreen(
                            storage.getArchive(
                                archiveNumber
                            )
                        )
                    )
                }
                "1" -> {
                    return Destination.OpenScreen(
                        Screen.OpenNoteScreen(
                            storage.getArchive(
                                archiveNumber
                            )
                        )
                    )
                }
                "2" -> {
                    return Destination.Back
                }
                else -> view.show("Введите верное число")
            }
        }
    }

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
                view.show(
                    "Выберите или создайте заметку: \n" +
                            "0. Создать заметку\n" +
                            "1. Это мой уже созданная заметка\n" +
                            "2. Возвращение на экран архивов"
                )
                return nextStep(input)
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

