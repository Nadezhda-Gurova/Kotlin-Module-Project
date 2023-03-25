package presenter

interface Presenter {

    fun start()

}

abstract class AbstractPresenter: Presenter {

    private var startedState = false

    final override fun start() {
        startedState = true
        while (startedState){
            loop()
        }
    }

    abstract fun loop()

    protected fun stop() {
        startedState = false
    }
}