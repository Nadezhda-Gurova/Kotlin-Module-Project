import navigation.Destination
import navigation.NavigationImpl
import navigation.Screen
import storage.StorageImpl
import view.ConsoleView

fun main() {
    val navigation = NavigationImpl(StorageImpl(), ConsoleView())
    navigation.navigate(Destination.OpenScreen(Screen.ArchivesScreen))
}
