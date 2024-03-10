package io.github.adrianogba.springollama.service

import org.springframework.ai.embedding.EmbeddingResponse

interface AiTrainingService {

    fun getEmbeddingsWithModelOverride(payload: String): EmbeddingResponse

    fun getEmbeddingsWithDefaultModel(payload: String): Map<String, EmbeddingResponse>
}
