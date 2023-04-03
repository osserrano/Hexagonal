package org.xavrs.hexagonal.springboot3.infrastructure.persistence.model

import org.xavrs.hexagonal.springboot3.domain.model.DomainModel

interface DBModel<T:DomainModel> {
    fun toDomainModel(): T
}