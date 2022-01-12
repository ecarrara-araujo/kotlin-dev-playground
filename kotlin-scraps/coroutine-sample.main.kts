#!/usr/bin/env kotlin

@file:Repository("https://repo.maven.apache.org/maven2/")
@file:DependsOn("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch

runBlocking {
    launch {
        println("This is a coroutine.")
    }
}

println("This is just the main program ...")