package br.com.gmfonseca.dependencyinjection.factories

import br.com.gmfonseca.dependencyinjection.contract.Definition
import br.com.gmfonseca.dependencyinjection.contract.Lazy
import br.com.gmfonseca.dependencyinjection.core.InstanceFactory

class LazyInstanceFactory<T>(definition: Definition<T>) : InstanceFactory<T> {
    private var value = Lazy(definition)

    override fun get(): T = value.instance
}

