package org.xavrs.streaming.springboot3.application.controller

import org.springframework.http.codec.ServerSentEvent
import org.springframework.messaging.MessageHandler
import org.springframework.messaging.SubscribableChannel
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.xavrs.streaming.springboot3.application.controller.model.ItemDTO
import org.xavrs.streaming.springboot3.application.stream.model.ItemStream
import reactor.core.publisher.Flux

@Controller
@RequestMapping("/api/event")
class SseController (private var itemDataChannel: SubscribableChannel){
    @GetMapping("/item")
    fun streamJobStatus(): Flux<ServerSentEvent<ItemStream>> {
        return Flux.create { sink ->
            val messageHandler = MessageHandler { message ->
                val item: ItemStream = message.payload as ItemStream
                sink.next(ServerSentEvent.builder<ItemStream>()
                    .id(item.reference!!)
                    .event("message")
                    .data(item)
                    .build())
            }
            itemDataChannel.subscribe(messageHandler)
        }
    }
}