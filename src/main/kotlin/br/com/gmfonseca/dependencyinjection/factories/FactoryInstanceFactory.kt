package br.com.gmfonseca.dependencyinjection.factories

import br.com.gmfonseca.dependencyinjection.contract.Definition
import br.com.gmfonseca.dependencyinjection.core.InstanceFactory

class FactoryInstanceFactory<T>(private val factory: Definition<T>) : InstanceFactory<T> {

    override fun get(): T = factory.create()
}
