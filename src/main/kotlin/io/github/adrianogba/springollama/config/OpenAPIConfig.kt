package io.github.adrianogba.springollama.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenAPIConfig {
    @Value("\${adrianogba.openapi.dev-url}")
    private val devUrl: String? = null

    @Value("\${adrianogba.openapi.prod-url}")
    private val prodUrl: String? = null

    @Bean
    fun myOpenAPI(): OpenAPI {
        val devServer = Server()
        devServer.url = devUrl
        devServer.description = "Server URL in Development environment"

        val prodServer = Server()
        prodServer.url = prodUrl
        prodServer.description = "Server URL in Production environment"

        val contact = Contact()
        contact.email = "ampontes93@gmail.com"
        contact.name = "Adrianogba"
        contact.url = "https://www.adrianogba.github.io"

        val mitLicense: License = License().name("MIT License").url("https://choosealicense.com/licenses/mit/")

        val info: Info = Info()
                .title("Tutorial Management API")
                .version("1.0")
                .contact(contact)
//                .description("This API exposes endpoints to manage tutorials.").termsOfService("https://www.bezkoder.com/terms")
                .license(mitLicense)

        return OpenAPI().info(info).servers(listOf(devServer, prodServer))
    }
}