package io.github.adrianogba.springollama.service

import io.github.adrianogba.springollama.model.AiResponse

interface AiAnsweringService {
    fun generateMessage(prompt: String?): AiResponse?
    fun generateJoke(topic: String?): AiResponse?
    fun chatWithRole(role: String, message: String): AiResponse?
}
