package br.com.gmfonseca.dependencyinjection

import br.com.gmfonseca.dependencyinjection.core.module

fun main() {
    val module = buildModules()

    println("- Foo -")
    println("FooBar:\t${module.get<FooBar>().bar.foo}")
    println("Bar:\t${module.get<Bar>().foo}")
    println("Foo:\t${module.get<Foo>()}")

    println("\n- Bar -")
    println("FooBar:\t${module.get<FooBar>().bar}")
    println("Bar:\t${module.get<Bar>()}")

    println("\n- FooBar -")
    println("FooBar:\t${module.get<FooBar>()}")
    println("FooBar:\t${module.get<FooBar>()}")
}

fun buildModules() = module {
    factory { Bar(get()) }
    lazy { Foo() }
    single { FooBar(get()) }
}

class Foo
class Bar(val foo: Foo)
class FooBar(val bar: Bar)