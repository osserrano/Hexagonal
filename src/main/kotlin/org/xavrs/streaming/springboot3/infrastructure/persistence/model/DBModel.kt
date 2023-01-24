package org.xavrs.streaming.springboot3.infrastructure.persistence.model

import org.xavrs.streaming.springboot3.domain.model.DomainModel

interface DBModel {
    fun toDomainModel(): DomainModel
}