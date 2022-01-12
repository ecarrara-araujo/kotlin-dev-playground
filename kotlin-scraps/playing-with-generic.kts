#!/usr/bin/env kotlin

class Box<T> {

    private val items: MutableList<T> = mutableListOf()

    fun storeItem(item: T) {
        items += item
    }

    fun printItems() {
        for ((index, item) in items.withIndex()) {
            println("Item $index: $item")
        }
    }
}

interface Stuff {
    val desc: String
}

interface AdultStuff : Stuff
interface ChildStuff : Stuff

data class KitchenUtensil(override val desc: String) : AdultStuff
data class Toy(override val desc: String): ChildStuff

data class Shoe(val brand: String)

val nikeShoe = Shoe("Nike")
val addidasShoe = Shoe("Addidas")

val anyBox = Box<Any>()

anyBox.storeItem(nikeShoe)
anyBox.storeItem(addidasShoe)
anyBox.storeItem("wololo")

anyBox.printItems()

val adultStuffBox = Box<AdultStuff>()
adultStuffBox.storeItem(KitchenUtensil("knife"))

// fun organizeChildStuff(box: Box<Stuff>, childStuff: List<ChildStuff>) {
//     for (item in childStuff) {
//         box.storeItem(item)
//     }
// }

// organizeChildStuff(adultStuffBox, listOf(Toy("car")))

adultStuffBox.printItems()

open class Animal {
    fun feed() { println("Feeding ${this::class.java} ....") }
}

class Herd<out T : Animal>(
    private val animals: MutableList<T> = mutableListOf() 
) {
    private var firstAnimal: T? = null  

    val size: Int get() = animals.size
    operator fun get(i: Int): T = animals[i]

    // fun feedAnimals(feeder: AnimalFeeder<T>) {
    //     for (i in 0 until this.size) {
    //         feeder.feedAnimal(this[i])
    //     }
    // }
} 

fun feedAnimals(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals[i].feed()
    }
}

class Cat : Animal() {
    fun cleanLitter() { println("Cleaning cat litter ...") }
}

class Horse : Animal() {
    fun ride() { println("Riding the horse ....") }
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()
    }
    feedAnimals(cats)
}

fun rideAllHorses(horses: Herd<Horse>) {
    for (i in 0 until horses.size) {
        horses[i].ride()
    }
    feedAnimals(horses)
}

val herdOfCats = Herd(mutableListOf(Cat(), Cat(), Cat()))
val herdOfHorses = Herd(mutableListOf(Horse(), Horse(), Horse()))

takeCareOfCats(herdOfCats)
rideAllHorses(herdOfHorses)

fun interface AnimalFeeder<T : Animal> {
    fun feedAnimal(animal: T)  
}

// val anyAnimalFeeder = object : AnimalFeeder<Animal> { 
//     override fun feedAnimal(animal: Animal) {
//         println("Feeder feeding animal: ${animal::class.java}")
//         animal.feed()
//     }
// }    

val anyAnimalFeeder = AnimalFeeder<Animal> { animal -> 
    println("Feeder feeding animal: ${animal::class.java}")
}   


fun <T : Animal> Herd<T>.feedAnimals(feeder: AnimalFeeder<T>) {
    for (i in 0 until this.size) {
        feeder.feedAnimal(this[i])
    }
}

herdOfCats.feedAnimals(anyAnimalFeeder)
herdOfHorses.feedAnimals(anyAnimalFeeder)

// val catFeeder: AnimalFeeder<Cat> = anyAnimalFeeder

fun <T> copyData(source: MutableList<out T>, destination: MutableList<in T>) {
    for (item in source) {
        destination.add(item)
    }
}