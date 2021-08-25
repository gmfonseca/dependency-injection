package br.com.gmfonseca.dependencyinjection.contract

fun interface Definition<out T> {
    fun create(): T
}

inline fun <reified T> factory(builder: Definition<T>): Pair<String, Definition<T>> = T::class.java.name to builder
