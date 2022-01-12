#!/usr/bin/env kotlin

data class UserId(val value: Long = 12873687L) {
    val shareableResourceId: String
        get() = value.toString()

    fun hasId() = value != EMPTY_USER_ID

    override fun toString(): String = value.toString()

    companion object {
        const val EMPTY_USER_ID = Long.MIN_VALUE
    }
}


// fun UserId?.toString(): String = "lalala"

val nullUserId: UserId? = null 
val nullUserIdString: String? = nullUserId?.toString()

val userId = UserId(1L)
val nullString: String? = null

println(nullUserId?.toString())
println(userId.toString())
println(nullUserIdString)