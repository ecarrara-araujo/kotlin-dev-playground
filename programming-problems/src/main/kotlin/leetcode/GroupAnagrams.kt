package leetcode

val input = arrayOf("eat","tea","tan","ate","nat","bat")
val output = listOf(listOf("bat"), listOf("nat","tan"), listOf("ate","eat","tea"))

fun main() {
    println(groupAnagrams(input))
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val results = hashMapOf<List<Char>, MutableList<String>>()

    for(word in strs) {
        val sortedWord = word.toList().sorted()
        results.getOrPut(sortedWord) { mutableListOf() }.also {
            results[sortedWord] = it.apply { add(word) }
        }
    }

    return results.values.toList()
}