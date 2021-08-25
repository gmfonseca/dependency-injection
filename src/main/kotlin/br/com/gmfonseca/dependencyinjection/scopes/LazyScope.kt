package br.com.gmfonseca.dependencyinjection.scopes

import br.com.gmfonseca.dependencyinjection.contract.Lazy
import br.com.gmfonseca.dependencyinjection.core.Scope
import kotlin.reflect.KClass

class LazyScope(private val instances: Map<String, Lazy<*>>) : Scope {

    override fun get(klass: KClass<*>): Any = createInstance(klass.java.name)

    override fun createInstance(classname: String): Any {
        return instances[classname]?.instance
            ?: throw IllegalStateException("No definition bean found for class $classname")
    }
}

