package br.com.gmfonseca.dependencyinjection.core

import kotlin.reflect.KClass

interface Scope {
    fun get(klass: KClass<*>): Any
    fun createInstance(classname: String): Any
}

