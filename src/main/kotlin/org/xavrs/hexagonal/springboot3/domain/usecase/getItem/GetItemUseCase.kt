package org.xavrs.hexagonal.springboot3.domain.usecase.getItem

import org.xavrs.hexagonal.springboot3.domain.model.ColorCode
import org.xavrs.hexagonal.springboot3.domain.model.Item
import org.xavrs.hexagonal.springboot3.domain.model.Reference

interface GetItemUseCase {
    operator fun invoke(reference: Reference, colorCode: ColorCode): Item?
}