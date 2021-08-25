package br.com.gmfonseca.dependencyinjection.contract

class Single<out T>(factory: Definition<T>) {
    val instance: T = factory.create()
}

inline fun <reified T> single(builder: Definition<T>): Pair<String, Single<T>> = T::class.java.name to Single(builder)
