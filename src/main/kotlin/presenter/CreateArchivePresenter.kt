package presenter

import Navigation
import storage.Storage
import view.ConsoleView

class CreateArchivePresenter(
    private val navigation: Navigation,
    private val storage: Storage,
    private val view: ConsoleView
) : AbstractPresenter() {

    override fun loop() {
        view.show("Создайте название архива или введите 0 для возвращения на экран архивов")
        val input = view.input()
        if (input.isNotEmpty() && input != "0") {
            storage.addArchive(input)
            while (true) {
                view.show("Введите 0, чтобы вернуться на экран просмотра архива")
                if (view.input() == "0") {
                    stop()
                    navigation.back()
                }
            }
        } else {
            if (input == "0") {
                stop()
                navigation.back()
            } else{
            view.show("Введите название")
            }
        }
    }
}
