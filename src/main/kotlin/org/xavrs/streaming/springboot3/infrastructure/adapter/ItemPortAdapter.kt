package org.xavrs.streaming.springboot3.infrastructure.adapter

import org.springframework.stereotype.Component
import org.xavrs.streaming.springboot3.domain.model.ColorCode
import org.xavrs.streaming.springboot3.domain.model.Item
import org.xavrs.streaming.springboot3.domain.model.Reference
import org.xavrs.streaming.springboot3.domain.port.ItemPort
import org.xavrs.streaming.springboot3.infrastructure.persistence.repository.ItemOracleRepository
import org.xavrs.streaming.springboot3.infrastructure.persistence.repository.ItemRedisRepository

@Component
class ItemPortAdapter(
    private val itemOracleRepository: ItemOracleRepository,
    private val itemRedisRepository: ItemRedisRepository
): ItemPort {
    /*override fun getItem(reference: Reference, colorCode: ColorCode): Item? {
        return itemOracleRepository.getProductStyleColorByBaseReferencesColor(
            reference = reference.value,
            color = colorCode.value
        ).firstOrNull()?.toDomainModel()
    }*/

    override fun getItem(reference: Reference, colorCode: ColorCode): Item? {
        val item = itemRedisRepository.findById("${reference.value}-${colorCode.value}")
        return if(item.isPresent){
            item.get().toDomainModel()
        }else{
            null
        }
    }
}