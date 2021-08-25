package br.com.gmfonseca.dependencyinjection.core

interface InstanceFactory<T> {
    fun get(): T
}