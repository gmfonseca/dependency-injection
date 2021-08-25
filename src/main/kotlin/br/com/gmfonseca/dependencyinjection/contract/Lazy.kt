package br.com.gmfonseca.dependencyinjection.contract

class Lazy<out T>(private val factory: Definition<T>) {
    private var _instance: @UnsafeVariance T? = null

    val instance: T get() = _instance ?: createInstance()

    private fun createInstance() = factory.create().also { _instance = it }
}

inline fun <reified T> lazy(builder: Definition<T>): Pair<String, Lazy<T>> = T::class.java.name to Lazy(builder)
