package org.xavrs.hexagonal.springboot3.domain.port

import org.xavrs.hexagonal.springboot3.domain.model.ColorCode
import org.xavrs.hexagonal.springboot3.domain.model.Item
import org.xavrs.hexagonal.springboot3.domain.model.Reference

interface ItemDBPort {
    fun getItem(reference: Reference, colorCode: ColorCode): Item?
}