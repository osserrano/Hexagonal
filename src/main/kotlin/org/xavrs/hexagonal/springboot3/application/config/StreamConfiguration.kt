package org.xavrs.hexagonal.springboot3.application.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StreamConfiguration{
    @Bean
    fun schemaRegistry(
        @Value("\${spring.kafka.properties.schema.registry.url}") schemaRegistry: String,
        @Value("\${spring.kafka.properties.schema.registry.url}") credentialsSource: String, //TODO bad
        @Value( "\${spring.kafka.properties.schema.registry.url}" ) userInfo: String //TODO bad
        ): Map<String,String> = mapOf(
            Pair("schema.registry.url",schemaRegistry),
            Pair("basic.auth.credentials.source",credentialsSource),
            Pair("basic.auth.user.info",userInfo)
        )
}