package br.com.gmfonseca.dependencyinjection.factories

import br.com.gmfonseca.dependencyinjection.contract.Definition
import br.com.gmfonseca.dependencyinjection.contract.Single
import br.com.gmfonseca.dependencyinjection.core.InstanceFactory

class SingletonInstanceFactory<T>(definition: Definition<T>) : InstanceFactory<T> {
    private var single = Single(definition)

    override fun get(): T = single.instance
}
