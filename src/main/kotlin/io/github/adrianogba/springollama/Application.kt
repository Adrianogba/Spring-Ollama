package io.github.adrianogba.springollama

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringOllamaApplication

fun main(args: Array<String>) {
    runApplication<SpringOllamaApplication>(*args)
}
