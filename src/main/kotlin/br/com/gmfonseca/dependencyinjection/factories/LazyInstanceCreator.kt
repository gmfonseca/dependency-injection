package br.com.gmfonseca.dependencyinjection.factories

import br.com.gmfonseca.dependencyinjection.contract.Creator
import br.com.gmfonseca.dependencyinjection.contract.Lazy
import br.com.gmfonseca.dependencyinjection.core.InstanceCreator

class LazyInstanceCreator<T>(creator: Creator<T>) : InstanceCreator<T> {
    private var value = Lazy(creator)

    override fun get(): T = value.instance
}

