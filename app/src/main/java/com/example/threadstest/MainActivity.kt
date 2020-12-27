package com.example.threadstest

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

fun main() {

    val counter = AtomicInteger( 0)

    fun increaseCounter() {
        repeat( 10000) {
            counter.incrementAndGet()
        }
    }
    fun showCounter() {

        println(counter)

    }

while(true) {

    val executor = Executors.newFixedThreadPool(5)

    executor.execute {
        Thread.sleep(10)
        executor.execute(::increaseCounter)
    }


    executor.execute {
        Thread.sleep(10)
        executor.execute(::increaseCounter)
    }
    executor.execute {
        Thread.sleep(10)
        executor.execute(::increaseCounter)
    }
    executor.execute {
        Thread.sleep(10)
        executor.execute(::increaseCounter)
    }
    executor.execute {
        Thread.sleep(1000)
        executor.execute(::showCounter)
    }
    executor.awaitTermination(20, TimeUnit.SECONDS)
}


  //  executor.shutdown()

}