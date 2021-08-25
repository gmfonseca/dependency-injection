package br.com.gmfonseca.dependencyinjection.scopes

import br.com.gmfonseca.dependencyinjection.contract.Definition
import br.com.gmfonseca.dependencyinjection.contract.Lazy
import br.com.gmfonseca.dependencyinjection.contract.Modules
import br.com.gmfonseca.dependencyinjection.contract.Single
import br.com.gmfonseca.dependencyinjection.core.Scope

sealed class Strategy(val scope: Scope) {
    class Singleton(dependencies: Modules<Single<*>>) : Strategy(SingletonScope(dependencies.modules))
    class Lazier(dependencies: Modules<Lazy<*>>) : Strategy(LazyScope(dependencies.modules))
    class Factory(factories: Modules<Definition<*>>) : Strategy(FactoryScope(factories.modules))
}
