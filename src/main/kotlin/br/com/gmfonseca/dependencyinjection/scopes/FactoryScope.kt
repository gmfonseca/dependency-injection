package br.com.gmfonseca.dependencyinjection.scopes

import br.com.gmfonseca.dependencyinjection.contract.Definition
import br.com.gmfonseca.dependencyinjection.core.Scope
import kotlin.reflect.KClass

class FactoryScope(
    private val factories: Map<String, Definition<*>>,
) : Scope {

    override fun get(klass: KClass<*>): Any {
        val classname = klass.java.name

        return createInstance(classname)
    }

    override fun createInstance(classname: String): Any {
        return factories[classname]?.create()
            ?: throw IllegalStateException("No definition bean found for class $classname")
    }
}
