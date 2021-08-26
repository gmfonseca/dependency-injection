package br.com.gmfonseca.dependencyinjection.core

import br.com.gmfonseca.dependencyinjection.contract.Creator
import br.com.gmfonseca.dependencyinjection.factories.FactoryInstanceCreator
import br.com.gmfonseca.dependencyinjection.factories.LazyInstanceCreator
import br.com.gmfonseca.dependencyinjection.factories.SingletonInstanceCreator

class Module {
    @PublishedApi
    internal val creators = mutableMapOf<String, InstanceCreator<*>>()

    inline fun <reified T> get(): T {
        val name = T::class.java.name

        return creators[name]?.get() as? T
            ?: throw IllegalStateException("No bean found of type $name")
    }

    inline fun <reified T> factory(creator: Creator<T>) {
        creators[T::class.java.name] = FactoryInstanceCreator(creator)
    }

    inline fun <reified T> single(creator: Creator<T>) {
        creators[T::class.java.name] = SingletonInstanceCreator(creator)
    }

    inline fun <reified T> lazy(creator: Creator<T>) {
        creators[T::class.java.name] = LazyInstanceCreator(creator)
    }
}

inline fun module(init: Module.() -> Unit): Module {
    return Module().apply { init() }
}
