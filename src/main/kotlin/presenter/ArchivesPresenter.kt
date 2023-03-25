package presenter

import navigation.Destination
import navigation.Screen
import view.View

class ArchivesPresenter(
    private val view: View
) : Presenter {

    override fun show(): Destination {
        while (true){
            view.show(
                "Выберите пункт.\n" +
                        "0. Создать архив\n" +
                        "1. Это мой уже созданный архив\n" +
                        "2. Выход "
            )

            when (view.input()) {
                "0" -> {
                    return Destination.OpenScreen(Screen.CreateArchiveScreen)
                }
                "1" -> {
                    return Destination.OpenScreen(Screen.OpenArchiveScreen)
                }
                "2" -> {
                    return Destination.Exit
                }
                else -> view.show("Введите верное число")
            }
        }
    }
}