package presenter

import Navigation
import view.ConsoleView

class ArchivesPresenter(
    private val navigation: Navigation,
    private val view: ConsoleView
) : AbstractPresenter() {

    override fun loop() {
        view.show("Выберите пункт.\n" +
                "0. Создать архив\n" +
                "1. Это мой уже созданный архив\n" +
                "2. Выход ")

        when (view.input()) {
            "0" -> {
                stop()
                navigation.createArchive()
            }
            "1" -> {
                stop()
                navigation.openArchive()
            }
            "2" -> {
                stop()
                navigation.exit()
            }
            else -> view.show("Введите верное число")
        }
    }
}