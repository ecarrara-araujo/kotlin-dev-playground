package br.com.ecarrara.basics

const val aBoolean = true

const val aChar = 'a'
const val aString = "aString"

const val aByte: Byte = 1
const val aShort: Short = 1
const val aInt: Int = 1_000_000
const val aLong: Long = 10L

const val aFloat: Float = 1.1F
const val aDouble: Double = 1.1

const val hexadecimal = 0xFF_EC_DE_5E
const val bits = 0b11010010_01101001_10010100_10010010

val aArray: Array<String> = arrayOf("One", "Two")
val aIntArray: IntArray = intArrayOf(1, 2, 3)
val aByteArray: ByteArray = byteArrayOf(1, 2, 3, 4)
val aShortArray: Array<String> = arrayOf("One", "Two")

// unsigned types
val aUnsignedByte: UByte = 1u
val aUnsignedShort: UShort = 1u
val aUnsignedInt: UInt = 1u
val aUnsignedLong: ULong = 1u
val aUnsignedHex = 0xFFFF_FFFF_FFFFu

// corresponding unsigned arrays
val aUnsignedIntArray: UIntArray = uintArrayOf(1u, 2u, 3u)
val aUnsignedByteArray: UByteArray = ubyteArrayOf(1u, 2u, 3u, 4u)
val aUnsignedShortArray: UShortArray = ushortArrayOf(1u, 2u, 3u)
val aUnsignedLongArray: ULongArray = ulongArrayOf(1u, 2u, 3u, 4u)

const val intDivisionResult = 1 / 1
val isDivisionResultAInt
    get() = intDivisionResult is Int // this is always true

const val intDivisionResultAsFloat = 1 / 1.toDouble()
val isDivisionResultAFloat
    get() = intDivisionResultAsFloat is Double // this is always true

fun bitwiseOperations() {
    val someNumber = 12345
    val numberOfBits = 10
    with(someNumber) {
        shl(numberOfBits)
        shl(numberOfBits) // signed shift left
        shr(numberOfBits) // signed shift right
        ushr(numberOfBits) // unsigned shift right
        and(numberOfBits) // bitwise and
        or(numberOfBits) // bitwise or
        xor(numberOfBits) // bitwise xor
        inv() // bitwise inversion
    }
}

fun booleanOperations(): Boolean {
    val booleanA = true
    val booleanB = false

    return booleanA && booleanB || booleanA || !booleanB
}

