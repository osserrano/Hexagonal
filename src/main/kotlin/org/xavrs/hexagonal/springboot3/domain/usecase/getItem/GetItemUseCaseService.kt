package org.xavrs.hexagonal.springboot3.domain.usecase.getItem

import org.springframework.stereotype.Service
import org.xavrs.hexagonal.springboot3.domain.model.ColorCode
import org.xavrs.hexagonal.springboot3.domain.model.Item
import org.xavrs.hexagonal.springboot3.domain.model.Reference
import org.xavrs.hexagonal.springboot3.domain.port.ItemDBPort

@Service
class GetItemUseCaseService(private val itemDBPort: ItemDBPort) : GetItemUseCase {
    override fun invoke(reference: Reference, colorCode: ColorCode): Item? {
        return itemDBPort.getItem(reference, colorCode)
    }
}