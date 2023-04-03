package org.xavrs.hexagonal.springboot3.infrastructure.adapter

import org.springframework.stereotype.Component
import org.xavrs.hexagonal.springboot3.domain.model.ColorCode
import org.xavrs.hexagonal.springboot3.domain.model.Item
import org.xavrs.hexagonal.springboot3.domain.model.Reference
import org.xavrs.hexagonal.springboot3.domain.port.ItemDBPort
import org.xavrs.hexagonal.springboot3.infrastructure.persistence.repository.ItemOracleRepository

@Component
class ItemDBPortAdapter(
    //TODO step8
    private val itemOracleRepository: ItemOracleRepository
): ItemDBPort {
    override fun getItem(reference: Reference, colorCode: ColorCode): Item? {
        return itemOracleRepository.getProductStyleColorByBaseReferencesColor(
            reference = reference.value,
            color = colorCode.value
        ).firstOrNull()?.toDomainModel()
    }

    //TODO step9
}