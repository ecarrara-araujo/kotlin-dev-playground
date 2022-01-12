#!/usr/bin/env kotlin

import java.io.File

val inputFilePath = args[0]
val outputFilePath = "./Colors.kt"
val colorLineRegex = """<color name="(.*)">(.*)<\/color>""".toRegex()

println("Starting to Process: $inputFilePath")

val outputFile = File(outputFilePath)
outputFile.delete()

outputFile.bufferedWriter().use { output ->
    File(inputFilePath).forEachLine {
        val lineMatchingResult = colorLineRegex.find(it)
        lineMatchingResult?.run {
            val (colorName, colorHex) = destructured
            val convertedLine = "val ${formatColorName(colorName)} = Color(${formatColorHex(colorHex)})"
            println("Writing to file: $colorName - $colorHex = $convertedLine")
            output.write(convertedLine)
            output.newLine()
        }
    }
}

fun formatColorName(colorName: String): String {
    return "_[a-zA-Z0-9]".toRegex().replace(colorName) { it.value.replace("_","").uppercase() }
}

fun formatColorHex(colorHex: String): String {
    return colorHex.replace(
        "#".toRegex(), 
        if (colorHex.length == 7) "0xFF" else "0x"
    )
}
