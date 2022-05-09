package br.com.gmfonseca.dependencyinjection.contract

class Lazy<out T>(private val creator: Creator<T>) {
    private var _instance: @UnsafeVariance T? = null

    val instance: T get() = _instance ?: createInstance()

    private fun createInstance() = creator.create().also { _instance = it }
}
