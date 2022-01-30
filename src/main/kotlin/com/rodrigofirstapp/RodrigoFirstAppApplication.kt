package com.rodrigofirstapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class RodrigoFirstAppApplication

fun main(args: Array<String>) {
	runApplication<RodrigoFirstAppApplication>(*args)
}
