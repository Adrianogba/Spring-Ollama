package io.github.adrianogba.springollama.service.impl

import io.github.adrianogba.springollama.model.AiResponse
import io.github.adrianogba.springollama.service.AiTrainingService
import org.springframework.ai.embedding.EmbeddingClient
import org.springframework.ai.embedding.EmbeddingRequest
import org.springframework.ai.embedding.EmbeddingResponse
import org.springframework.ai.ollama.api.OllamaOptions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class AiTrainingServiceImpl @Autowired constructor(
    private val embeddingClient: EmbeddingClient
) : AiTrainingService {

    override fun getEmbeddingsWithModelOverride(payload: String): EmbeddingResponse {
        return embeddingClient.call(EmbeddingRequest(
                listOf(payload),
                OllamaOptions.create().withModel("llama2")))
    }

    override fun getEmbeddingsWithDefaultModel(payload: String): Map<String, EmbeddingResponse> {
        val embeddingResponse: EmbeddingResponse = embeddingClient.embedForResponse(
                listOf(payload))
        return java.util.Map.of("embedding", embeddingResponse)
    }
}
