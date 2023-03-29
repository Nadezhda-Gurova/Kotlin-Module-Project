package presenter

import navigation.Destination
import storage.Storage
import view.View

class CreateArchivePresenter(
    private val storage: Storage,
    private val view: View
) : Presenter {

    override fun show(): Destination {
        while (true) {
            view.show("Создайте название архива или введите 0 для возвращения на экран архивов")
            val input = view.input()
            if (input.isNotEmpty() && input != "0") {
                storage.addArchive(input)
                while (true) {
                    view.show("Введите 0, чтобы вернуться на экран просмотра архива")
                    if (view.input() == "0") {
                        return Destination.Back
                    }
                }
            } else {
                if (input == "0") {
                    return Destination.Back
                } else {
                    view.show("Введите название")
                }
            }
        }
    }
}

