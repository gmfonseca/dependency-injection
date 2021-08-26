package br.com.gmfonseca.dependencyinjection.contract

fun interface Creator<out T> {
    fun create(): T
}
