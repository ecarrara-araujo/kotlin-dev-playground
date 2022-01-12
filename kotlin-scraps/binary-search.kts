fun List<Int>.binarySearch(number: Int): Int {
    var lowerBound = 0
    var upperBound = lastIndex
    
    while (lowerBound <= upperBound) {
        var midpoint = (upperBound + lowerBound) / 2
        var midpointValue = this[midpoint]
        when {
            midpointValue == number -> return midpoint
            midpointValue > number -> upperBound = midpoint - 1
            midpointValue < number -> lowerBound = midpoint + 1
        }
    }

    return -1
}

val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

val binarySearchReturn = list.binarySearch(4)

if (binarySearchReturn >= 0) {
    println("Number found on position: $binarySearchReturn")
} else { 
    println("Number not found.")
}
