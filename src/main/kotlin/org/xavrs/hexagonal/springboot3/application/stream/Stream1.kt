package org.xavrs.hexagonal.springboot3.application.stream

import com.sksamuel.avro4k.Avro
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KeyValue
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed
import org.apache.kafka.streams.kstream.Produced
import org.springframework.stereotype.Component
import org.xavrs.hexagonal.springboot3.application.adapter.ItemStreamAdapter
import org.xavrs.hexagonal.springboot3.application.stream.model.ItemSerde
import org.xavrs.hexagonal.springboot3.application.stream.model.ItemStream
import org.xavrs.hexagonal.springboot3.domain.exception.ItemException


@Component
class Stream1 (
    streamsBuilder: StreamsBuilder,
    schemaRegistry: Map<String,String>,
    itemStreamAdapter: ItemStreamAdapter
) {
    init {
        streamsBuilder.stream("test", Consumed.with(Serdes.String(), ItemSerde()))
            .map{ key, value ->
                try {
                    val item = itemStreamAdapter.getItem(value.reference!!, value.color!!)
                    KeyValue(
                        key,
                        Avro.default.toRecord(
                            ItemStream.serializer(),
                            ItemStream(item?.reference?.value,item?.color?.colorCode?.value,item?.name)
                        )
                    )
                }catch (ex: ItemException){
                    KeyValue(
                        key,
                        Avro.default.toRecord(
                            ItemStream.serializer(),
                            ItemStream(null, null, null)
                        ))
                }
            }
            .filter { _, value ->  value.get("reference") != null }
            .to("test-avro", Produced.with(Serdes.String(),GenericAvroSerde().apply{
                configure(schemaRegistry,false)
            }
            ))
    }

}
