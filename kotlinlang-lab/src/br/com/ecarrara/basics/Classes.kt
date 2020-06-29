package br.com.ecarrara.basics

object Singleton {
    val aString: String = "aString"
}

class OneClass(
    val someIntField: Int
) {
    val aProperty: String = "value"
    var aMutableProperty: String = "value"
    val aNullableProperty: String? = null

    fun aPublicFun() = Unit
    fun aPublicFun(aArgument: String): String = "aTextReturn"

    private fun aPrivateFun() = Unit

    private fun aPrintFun(text: String) {
        println(text)
    }
}

data class DataClass(
    val id: Long,
    val type: String
)

enum class SomeTypes { TYPE1, TYPE2, TYPE3, DEFAULT }

sealed class SealedType
object SealedType1 : SealedType()
class SealedType2(val text: String) : SealedType()

open class BaseClass
class ChildClass : BaseClass()

abstract class AbstractClass {
    abstract val aAbstractProp: String
    abstract var aMutableAbstractProp: String

    abstract fun implementMe(someParameter: String): Int
}

class ImplementationClass(
    override val aAbstractProp: String,
    override var aMutableAbstractProp: String
) : AbstractClass() {
    override fun implementMe(someParameter: String): Int {
        println("this is some parameter $someParameter")
        return 1 + 1
    }
}