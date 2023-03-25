package presenter

import navigation.Destination
import navigation.Screen
import storage.Storage
import view.View

class OpenArchivePresenter(
    private val storage: Storage,
    private val view: View
) : Presenter {

    private fun nextStep(archiveName: String): Destination {
        while (true) {
            when (view.input()) {
                "0" -> {
                    return Destination.OpenScreen(
                        Screen.CreateNoteScreen(
                            storage.getArchive(
                                archiveName
                            )
                        )
                    )
                }
                "1" -> {
                    return Destination.OpenScreen(
                        Screen.OpenNoteScreen(
                            storage.getArchive(
                                archiveName
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
                "Выберите архив: \n${storage.getArchives().joinToString("\n")} \n" +
                        "или введите 2 для возвращения на экран архивов"
            )
            val input = view.input()
            if (input in storage.getArchives()) {
                view.show(
                    "Выберите или создайте заметку: \n" +
                            "0. Создать заметку\n" +
                            "1. Это мой уже созданная заметка\n" +
                            "2. Возвращение на экран архивов"
                )
                return nextStep(input)
            } else {
                if (input == "2") {
                    return Destination.Back
                } else {
                    view.show("Введите название архива")
                }
            }
        }
    }
}

