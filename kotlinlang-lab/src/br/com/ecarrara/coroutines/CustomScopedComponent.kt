package br.com.ecarrara.coroutines

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope

@ExperimentalCoroutinesApi
fun main() = runBlocking {
    val testScope = TestCoroutineScope(Job())
    val component = CustomScopedComponent()
    component.execute()

    delay(8000L)
    println("Before clear Test Scope is: ${testScope.isActive}")
    component.clear()
    println("After clear Test Scope is: ${testScope.isActive}")
    delay(2000L)
    println("Program Finished")
}

class CustomScopedComponent(
    private val producerComponent: ProducerComponent = ProducerComponent(),
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Default)
) {
    private var job: Job? = null
    fun execute() {
        if (job?.isActive == true) return

//        job = scope.launch {
//            try {
//                producerComponent.produce().collect { item ->
//                    println("Item Produced: $item")
//                }
//            } catch (cancellation: CancellationException) {
//                println("Task was cancelled no special treatment is needed ...")
//                throw cancellation
//            } catch (exception: Exception) {
//                println(exception)
//            }
//        }

        job = scope.launch {
            runCatching {
                producerComponent.produce().collect { item ->
                    println("Item Produced: $item")
                }
            }.onFailure { exception ->
                when (exception) {
//                    is CancellationException -> {
////                        println(exception)
////                        throw exception
//                    }
                    else -> println(exception)
                }
            }
        }
    }

    fun clear() {
        scope.cancel()
    }
}

class ProducerComponent {
    fun produce() = flow {
        var counter = 0
        while (true) {
            delay(PRODUCER_DEFAULT_DELAY)
            emit(true)
            counter++
            if (counter >= 15) throw RuntimeException("Run way to many times...")
        }
    }

    companion object {
        const val PRODUCER_DEFAULT_DELAY = 1000L
    }
}