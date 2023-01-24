package org.xavrs.streaming.springboot3.application.adapter

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.xavrs.streaming.springboot3.application.controller.model.ItemDTO
import org.xavrs.streaming.springboot3.domain.getItem.GetItemUseCase
import org.xavrs.streaming.springboot3.domain.model.ColorCode
import org.xavrs.streaming.springboot3.domain.model.Item
import org.xavrs.streaming.springboot3.domain.model.Reference

@Component
class ItemAdapter (private val getItemUseCase: GetItemUseCase) {

    fun getItemForController(reference: String, colorCode: String): ResponseEntity<ItemDTO?>{
        var response: ResponseEntity<ItemDTO?> = ResponseEntity.notFound().build()
        getItemUseCase(
            reference = Reference(reference),
            colorCode = ColorCode(colorCode)
        )?.let { item ->
            response = ResponseEntity.ok(
                ItemDTO(
                    reference = item.reference.value,
                    color = item.color.colorCode.value,
                    name = item.name
                )
            )
        }
        return response
    }

    fun getItemForStream(reference: String, colorCode: String): Item?{

        val response = getItemUseCase(
            reference = Reference(reference),
            colorCode = ColorCode(colorCode)
        )
        return response
    }
}