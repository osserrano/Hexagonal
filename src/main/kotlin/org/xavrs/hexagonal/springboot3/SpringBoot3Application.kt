package org.xavrs.hexagonal.springboot3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.EnableKafkaStreams

@SpringBootApplication
//TODO step0
class SpringBoot3Application

fun main(args: Array<String>) {
    runApplication<org.xavrs.hexagonal.springboot3.SpringBoot3Application>(*args)
}
