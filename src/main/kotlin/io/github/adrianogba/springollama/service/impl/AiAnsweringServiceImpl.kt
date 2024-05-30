package io.github.adrianogba.springollama.service.impl

import io.github.adrianogba.springollama.model.AiResponse
import io.github.adrianogba.springollama.service.AiAnsweringService
import org.springframework.ai.chat.ChatClient
import org.springframework.ai.ollama.api.OllamaApi
import org.springframework.ai.ollama.api.OllamaApi.ChatRequest
import org.springframework.ai.ollama.api.OllamaOptions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service


@Service
class AiAnsweringServiceImpl @Autowired constructor(
    private val chatClient: ChatClient,
    @Value("\${OLLAMA_MODEL:mistral}") private val model: String,
    @Value("\${spring.ai.ollama.base-url}") private val ollamaBaseUrl: String,
) : AiAnsweringService {
    override fun generateMessage(prompt: String?): AiResponse = AiResponse(chatClient.call(prompt))

    override fun chatWithRole(role: String, message: String): AiResponse {
        val ollamaApi = OllamaApi(ollamaBaseUrl)

        val request = ChatRequest.builder(model)
            .withStream(false)
            .withMessages(listOf(
                OllamaApi.Message.builder(OllamaApi.Message.Role.SYSTEM)
                    .withContent(role)
                    .build(),
                OllamaApi.Message.builder(OllamaApi.Message.Role.USER)
                    .withContent(message)
                    .build()))
            .withOptions(OllamaOptions.create().withTemperature(0.9f))
            .build()

        val response: OllamaApi.ChatResponse = ollamaApi.chat(request)
        return AiResponse(response.message.content)

    }

    override fun generateJoke(topic: String?): AiResponse {
        val message = chatClient.call(String.format("Tell me a joke about %s", topic))
        return AiResponse(message)
    }
}
