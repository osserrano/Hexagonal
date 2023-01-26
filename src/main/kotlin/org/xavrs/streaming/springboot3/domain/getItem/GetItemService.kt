package org.xavrs.streaming.springboot3.domain.getItem

import org.springframework.stereotype.Service
import org.xavrs.streaming.springboot3.domain.model.ColorCode
import org.xavrs.streaming.springboot3.domain.model.Item
import org.xavrs.streaming.springboot3.domain.model.Reference
import org.xavrs.streaming.springboot3.domain.port.ItemDBPort

@Service
class GetItemService(private val itemDBPort: ItemDBPort) : GetItemUseCase {
    override fun invoke(reference: Reference, colorCode: ColorCode): Item? {
        return itemDBPort.getItem(reference, colorCode)
    }
}