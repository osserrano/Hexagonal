package org.xavrs.streaming.springboot3.domain.getItem

import org.xavrs.streaming.springboot3.domain.model.ColorCode
import org.xavrs.streaming.springboot3.domain.model.Item
import org.xavrs.streaming.springboot3.domain.model.Reference

interface GetItemUseCase {
    operator fun invoke(reference: Reference, colorCode: ColorCode): Item?
}