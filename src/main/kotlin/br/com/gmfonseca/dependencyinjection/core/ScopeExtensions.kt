package br.com.gmfonseca.dependencyinjection.core

inline fun <reified T> Scope.get(): T {
    return get(T::class) as? T
        ?: throw IllegalStateException("No bean found of type ${T::class.java.name}")
}
