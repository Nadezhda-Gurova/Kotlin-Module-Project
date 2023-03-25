import storage.StorageImpl

fun main() {
    val navigation = NavigationImpl(StorageImpl())
    navigation.archives()
}
