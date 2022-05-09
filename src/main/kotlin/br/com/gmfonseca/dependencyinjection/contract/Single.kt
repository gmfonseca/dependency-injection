package br.com.gmfonseca.dependencyinjection.contract

class Single<out T>(creator: Creator<T>) {
    val instance: T = creator.create()
}
