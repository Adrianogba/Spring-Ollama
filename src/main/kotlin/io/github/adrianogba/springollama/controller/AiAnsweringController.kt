package io.github.adrianogba.springollama.controller

import io.github.adrianogba.springollama.model.AiResponse
import io.github.adrianogba.springollama.service.AiAnsweringService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "AI Questioning")
class AiAnsweringController @Autowired constructor(private val aiAnsweringService: AiAnsweringService) {
    @GetMapping("api/v1/generate")
    fun generate(@RequestParam(value = "message") promptMessage: String?): ResponseEntity<AiResponse?> {
        val aiResponse = aiAnsweringService.generateMessage(promptMessage)
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse)
    }

    @GetMapping("api/v1/chat/")
    fun chatWithContext(@RequestParam role: String, @RequestParam message: String): ResponseEntity<AiResponse?> {
        val aiResponse = aiAnsweringService.chatWithRole(role, message)
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse)
    }

    @GetMapping("api/v1/generate/joke/{topic}")
    fun generateJoke(@PathVariable topic: String?): ResponseEntity<AiResponse?> {
        val aiResponse = aiAnsweringService.generateJoke(topic)
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse)
    }


}
