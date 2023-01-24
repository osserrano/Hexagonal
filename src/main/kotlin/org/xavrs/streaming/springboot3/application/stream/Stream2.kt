package org.xavrs.streaming.springboot3.application.stream

import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed
import org.springframework.messaging.SubscribableChannel
import org.springframework.messaging.support.GenericMessage
import org.springframework.stereotype.Component
import org.xavrs.streaming.springboot3.application.stream.model.ItemStream

@Component
class Stream2 (streamsBuilder: StreamsBuilder,
               schemaRegistry: Map<String,String>,
               itemDataChannel: SubscribableChannel
){

    init {
        streamsBuilder.stream("test-avro", Consumed.with(
            Serdes.String(),
            GenericAvroSerde().apply{
                configure(schemaRegistry, false)
            })
        ).peek { _, value ->
            itemDataChannel.send(GenericMessage(ItemStream(value)))
        }
    }

}