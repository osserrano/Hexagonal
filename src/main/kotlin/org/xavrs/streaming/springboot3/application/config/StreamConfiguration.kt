package org.xavrs.streaming.springboot3.application.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StreamConfiguration{

    @Bean
    fun schemaRegistry(
        @Value( "\${spring.kafka.properties.schema.registry.url}" ) schemaRegistryUrl: String,
        @Value( "\${spring.kafka.properties.schema.registry.url}" ) credentialsSource: String,
        @Value( "\${spring.kafka.properties.schema.registry.url}" ) userInfo: String
    ): Map<String, String> = mapOf(
        Pair("schema.registry.url", schemaRegistryUrl),
        Pair("basic.auth.credentials.source",credentialsSource),
        Pair("basic.auth.user.info",userInfo)
    )
}