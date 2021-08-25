package br.com.gmfonseca.dependencyinjection

import br.com.gmfonseca.dependencyinjection.contract.Definition
import br.com.gmfonseca.dependencyinjection.contract.Lazy
import br.com.gmfonseca.dependencyinjection.contract.Modules
import br.com.gmfonseca.dependencyinjection.contract.Single
import br.com.gmfonseca.dependencyinjection.contract.factory
import br.com.gmfonseca.dependencyinjection.contract.lazy
import br.com.gmfonseca.dependencyinjection.contract.modules
import br.com.gmfonseca.dependencyinjection.contract.single
import br.com.gmfonseca.dependencyinjection.core.get
import br.com.gmfonseca.dependencyinjection.scopes.Strategy

fun main() {
    val singletonStrategy = Strategy.Singleton(singleModules())
    val lazyStrategy = Strategy.Lazier(lazyModules())
    val factoryStrategy = Strategy.Factory(factoryModules())

    val scopes = listOf(
        singletonStrategy.scope,
        lazyStrategy.scope,
        factoryStrategy.scope,
    )

    scopes.forEach { println(it.get<String>()) }
}

fun singleModules(): Modules<Single<*>> = modules(
    single { "single" },
)

fun lazyModules(): Modules<Lazy<*>> = modules(
    lazy { "lazy" },
)

fun factoryModules(): Modules<Definition<*>> = modules(
    factory { "factory" },
)
