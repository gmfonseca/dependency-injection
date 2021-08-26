package br.com.gmfonseca.dependencyinjection.contract

class Lazy<out T>(private val factory: Creator<T>) {
    private var _instance: @UnsafeVariance T? = null

    val instance: T get() = _instance ?: createInstance()

    private fun createInstance() = factory.create().also { _instance = it }
}
