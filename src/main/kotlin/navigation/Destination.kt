package navigation

sealed class Destination {

    class OpenScreen(val screen: Screen) : Destination()

    object Back : Destination()

    object Exit : Destination()
}

