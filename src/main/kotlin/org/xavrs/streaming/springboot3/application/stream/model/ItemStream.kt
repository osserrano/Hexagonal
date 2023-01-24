package org.xavrs.streaming.springboot3.application.stream.model

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.serialization.Serializable
import org.apache.avro.generic.GenericRecord
import org.apache.avro.util.Utf8
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serializer

@Serializable
data class ItemStream (
    val reference: String?,
    val color: String?,
    val name: String?
){
    constructor(record: GenericRecord) : this(
        reference = (record.get("reference") as Utf8).toString(),
        color = (record.get("color") as Utf8).toString(),
        name = (record.get("name") as Utf8).toString()
    )
}

class ItemSerde : Serde<ItemStream> {

    private val mapper = jacksonObjectMapper()

    override fun deserializer(): Deserializer<ItemStream> {
        return Deserializer { _, value ->
            mapper.readValue<ItemStream>(value)
        }
    }

    override fun serializer(): Serializer<ItemStream> {
        return Serializer { _, value -> mapper.writeValueAsBytes(value) }
    }
}
