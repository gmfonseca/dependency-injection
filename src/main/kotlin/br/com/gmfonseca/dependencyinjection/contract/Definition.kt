package br.com.gmfonseca.dependencyinjection.contract

fun interface Definition<out T> {
    fun create(): T
}
