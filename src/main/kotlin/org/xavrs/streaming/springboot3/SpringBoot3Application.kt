package org.xavrs.streaming.springboot3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.EnableKafkaStreams

@SpringBootApplication
//TODO step0
class SpringBoot3Application

fun main(args: Array<String>) {
    runApplication<SpringBoot3Application>(*args)
}
