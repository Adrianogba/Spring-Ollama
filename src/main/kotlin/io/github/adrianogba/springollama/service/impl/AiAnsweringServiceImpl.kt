package io.github.adrianogba.springollama.service.impl

import io.github.adrianogba.springollama.model.AiResponse
import io.github.adrianogba.springollama.service.AiAnsweringService
import org.springframework.ai.chat.ChatClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AiAnsweringServiceImpl @Autowired constructor(
    private val chatClient: ChatClient
) : AiAnsweringService {
    override fun generateMessage(prompt: String?): AiResponse {
        return AiResponse(chatClient.call(prompt))
    }

    override fun generateJoke(topic: String?): AiResponse {
        val message = chatClient.call(String.format("Tell me a joke about %s", topic))
        return AiResponse(message)
    }
}
