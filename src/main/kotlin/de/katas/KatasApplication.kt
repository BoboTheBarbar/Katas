package de.katas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KatasApplication

fun main(args: Array<String>) {
	runApplication<KatasApplication>(*args)
}