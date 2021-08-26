package br.com.gmfonseca.dependencyinjection.factories

import br.com.gmfonseca.dependencyinjection.contract.Creator
import br.com.gmfonseca.dependencyinjection.contract.Single
import br.com.gmfonseca.dependencyinjection.core.InstanceCreator

class SingletonInstanceCreator<T>(creator: Creator<T>) : InstanceCreator<T> {
    private var single = Single(creator)

    override fun get(): T = single.instance
}
