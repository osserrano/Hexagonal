package org.xavrs.streaming.springboot3.application.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.dsl.MessageChannels
import org.springframework.messaging.SubscribableChannel

@Configuration
class ChannelConfiguration {
    @Bean
    fun itemDataChannel(): SubscribableChannel {
        return MessageChannels.publishSubscribe().get()
    }
}