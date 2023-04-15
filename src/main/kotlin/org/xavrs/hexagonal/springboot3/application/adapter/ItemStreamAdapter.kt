package org.xavrs.hexagonal.springboot3.application.adapter
import org.springframework.stereotype.Component
import org.xavrs.hexagonal.springboot3.domain.model.ColorCode
import org.xavrs.hexagonal.springboot3.domain.model.Item
import org.xavrs.hexagonal.springboot3.domain.model.Reference
import org.xavrs.hexagonal.springboot3.domain.usecase.getItem.GetItemUseCase

@Component
class ItemStreamAdapter(private val getItemUseCase: GetItemUseCase) {
    fun getItem(reference: String, colorCode: String): Item? {
        return getItemUseCase(
            reference = Reference(reference),
            colorCode = ColorCode(colorCode)
        )
    }
}