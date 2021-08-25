package br.com.gmfonseca.dependencyinjection.contract

class Single<out T>(factory: Definition<T>) {
    val instance: T = factory.create()
}
