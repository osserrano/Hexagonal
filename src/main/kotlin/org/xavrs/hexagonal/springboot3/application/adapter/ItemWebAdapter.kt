package org.xavrs.hexagonal.springboot3.application.adapter

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.xavrs.hexagonal.springboot3.application.controller.model.ItemDTO
import org.xavrs.hexagonal.springboot3.domain.usecase.getItem.GetItemUseCase
import org.xavrs.hexagonal.springboot3.domain.model.ColorCode
import org.xavrs.hexagonal.springboot3.domain.model.Reference

@Component
class ItemWebAdapter(private val getItemUseCase: GetItemUseCase) {

    fun getItem(reference: String, colorCode: String): ResponseEntity<ItemDTO?> =
        getItemUseCase(
            reference = Reference(reference),
            colorCode = ColorCode(colorCode)
        )?.let { item ->
            ResponseEntity.ok(
                ItemDTO(
                    reference = item.reference.value,
                    color = item.color.colorCode.value,
                    name = item.name
                )
            )
        } ?: ResponseEntity.notFound().build()
}
