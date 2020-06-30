package br.com.ecarrara.basics

const val anotherString = "this is some string"

// raw string cannot have escaped chars
val veryLongString = """
    |this is some very long string
    |this is some very long string
    |this is some very long string
    |this is some very long string
    |this is some very long string
""".trimMargin() // remove the indentation margin

const val escapedString = "This is interesting!\n"

const val someValue = 1234

fun aACalculatedValue() = 32 * 4

const val aStringTemplate = "Some value value: $someValue"
val anotherTemplate = "Some value value: ${aACalculatedValue()})"

const val rawStringTemplate = """
${'$'}$someValue
"""