package leetcode

/**
 * Given an MxN integer matrix, if an element is 0 set the whole row and column to 0 and return the matrix.
 * Operation must be done in place.
 */

val inputMatrix = arrayOf(intArrayOf(1,1,1), intArrayOf(1,0,1), intArrayOf(1,1,1))
val expectedOutput = arrayOf(intArrayOf(1,0,1), intArrayOf(0,0,0), intArrayOf(1,0,1))

fun Array<IntArray>.getContentString(): String {
    return joinToString(separator = ", ", prefix = "[", postfix = "]") {
        it.joinToString(separator = ", ", prefix = "[", postfix = "]")
    }
}

fun main() {
    println("input: ${inputMatrix.getContentString()}")
    setZeroes(inputMatrix)
    println("output: ${inputMatrix.getContentString()}")
    println(inputMatrix.contentEquals(expectedOutput))
}

fun setZeroes(matrix: Array<IntArray>) {
    val linesToZero = mutableSetOf<Int>()
    val columnsToZero = mutableSetOf<Int>()

    matrix.forEachIndexed { lineIndex, line ->
        line.forEachIndexed { columnIndex, value ->
            if (value == 0) {
                linesToZero.add(lineIndex)
                columnsToZero.add(columnIndex)
            }
        }
    }

    linesToZero.forEach { line ->
        for (column in matrix[line].indices) {
            matrix[line][column] = 0
        }
    }

    columnsToZero.forEach { column ->
        for (line in matrix.indices) {
            matrix[line][column] = 0
        }
    }
}