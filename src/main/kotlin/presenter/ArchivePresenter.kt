package presenter

import navigation.Destination
import navigation.Screen
import storage.Archive
import view.View

class ArchivePresenter(
    private val archive: Archive,
    private val view: View
) : Presenter {
    private fun nextStep(): Destination {
        while (true) {
            when (view.input()) {
                "0" -> {
                    return Destination.OpenScreen(
                        Screen.CreateNoteScreen(
                            archive
                            )
                        )
                }
                "1" -> {
                    return Destination.OpenScreen(
                        Screen.OpenNoteScreen(
                            archive
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
        while (true){
            view.show(
                "Выберите или создайте заметку: \n" +
                        "0. Создать заметку\n" +
                        "1. Это мой уже созданная заметка\n" +
                        "2. Возвращение на экран архивов"
            )
            return nextStep()
        }
    }
}