package br.com.gmfonseca.dependencyinjection.contract

@JvmInline
value class Modules<T>(val modules: Map<String, T>)

fun <T> modules(vararg pairs: Pair<String, T>): Modules<T> = Modules(mapOf(*pairs))
