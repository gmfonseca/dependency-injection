package br.com.gmfonseca.dependencyinjection.scopes

import br.com.gmfonseca.dependencyinjection.contract.Single
import br.com.gmfonseca.dependencyinjection.core.Scope
import kotlin.reflect.KClass

class SingletonScope(private val instances: Map<String, Single<*>>) : Scope {

    override fun get(klass: KClass<*>): Any = createInstance(klass.java.name)

    override fun createInstance(classname: String): Any {
        return instances[classname]?.instance
            ?: throw IllegalStateException("No bean found for class $classname")
    }
}
