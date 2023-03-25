package presenter

import Navigation
import storage.Storage
import view.ConsoleView

class OpenArchivePresenter(
    private val navigation: Navigation,
    private val storage: Storage,
    private val view: ConsoleView
) : AbstractPresenter() {
    override fun loop() {

        view.show(
            "Выберите архив: \n${storage.getArchives().joinToString("\n")} \n" +
                    "или введите 2 для возвращения на экран архивов"
        )
        val input = view.input()
        if (input in storage.getArchives()) {
            stop()
            view.show(
                "Выберите или создайте заметку: \n" +
                        "0. Создать заметку\n" +
                        "1. Это мой уже созданная заметка\n" +
                        "2. Возвращение на экран архивов"
            )
            nextStep(input)
        } else {
            if (input == "2") {
                stop()
                navigation.back()
            } else {
                view.show("Введите название архива")
            }
        }

    }

    private fun nextStep(archiveName: String) {
        while (true) {
            return when (view.input()) {
                "0" -> {
                    stop()
                    navigation.createNote(storage.getArchive(archiveName))
                }
                "1" -> {
                    stop()
                    navigation.openNote(storage.getArchive(archiveName))
                }
                "2" -> {
                    stop()
                    navigation.back()
                }
                else -> view.show("Введите верное число")
            }
        }
    }
}

