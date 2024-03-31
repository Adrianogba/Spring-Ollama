package io.github.adrianogba.springollama.controller

import io.github.adrianogba.springollama.service.AiTrainingService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.ai.embedding.EmbeddingResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "AI Training")
class AiTrainingController @Autowired constructor(private val aiTrainingService: AiTrainingService) {

    @GetMapping("api/v1/training")
    fun generate(@RequestParam(value = "message") promptMessage: String): ResponseEntity<Map<String, EmbeddingResponse>> {
        val aiResponse = aiTrainingService.getEmbeddingsWithDefaultModel(promptMessage)
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse)
    }

}
