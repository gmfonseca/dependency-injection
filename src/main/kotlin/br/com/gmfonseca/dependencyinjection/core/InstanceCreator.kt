package br.com.gmfonseca.dependencyinjection.core

interface InstanceCreator<T> {
    fun get(): T
}
