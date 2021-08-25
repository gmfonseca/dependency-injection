package br.com.gmfonseca.dependencyinjection.core

import br.com.gmfonseca.dependencyinjection.contract.Definition
import br.com.gmfonseca.dependencyinjection.factories.FactoryInstanceFactory
import br.com.gmfonseca.dependencyinjection.factories.LazyInstanceFactory
import br.com.gmfonseca.dependencyinjection.factories.SingletonInstanceFactory

class Module {
    @PublishedApi
    internal val factories = mutableMapOf<String, InstanceFactory<*>>()

    inline fun <reified T> get(): T {
        val name = T::class.java.name

        return factories[name]?.get() as? T
            ?: throw IllegalStateException("No bean found of type $name")
    }

    inline fun <reified T> factory(definition: Definition<T>) {
        factories[T::class.java.name] = FactoryInstanceFactory(definition)
    }

    inline fun <reified T> single(definition: Definition<T>) {
        factories[T::class.java.name] = SingletonInstanceFactory(definition)
    }

    inline fun <reified T> lazy(definition: Definition<T>) {
        factories[T::class.java.name] = LazyInstanceFactory(definition)
    }
}

inline fun module(init: Module.() -> Unit): Module {
    return Module().apply { init() }
}
