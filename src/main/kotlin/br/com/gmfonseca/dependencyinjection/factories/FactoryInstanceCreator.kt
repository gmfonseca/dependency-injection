package br.com.gmfonseca.dependencyinjection.factories

import br.com.gmfonseca.dependencyinjection.contract.Creator
import br.com.gmfonseca.dependencyinjection.core.InstanceCreator

class FactoryInstanceCreator<T>(private val factory: Creator<T>) : InstanceCreator<T> {

    override fun get(): T = factory.create()
}
