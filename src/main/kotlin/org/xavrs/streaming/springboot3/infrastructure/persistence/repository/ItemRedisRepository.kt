package org.xavrs.streaming.springboot3.infrastructure.persistence.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.xavrs.streaming.springboot3.infrastructure.persistence.model.RedisItemModel

@Repository
interface ItemRedisRepository : CrudRepository<RedisItemModel, String>