package br.com.gmfonseca.dependencyinjection.contract

class Single<out T>(factory: Creator<T>) {
    val instance: T = factory.create()
}
