package org.xavrs.streaming.springboot3.domain.port

import org.xavrs.streaming.springboot3.domain.model.ColorCode
import org.xavrs.streaming.springboot3.domain.model.Item
import org.xavrs.streaming.springboot3.domain.model.Reference

interface ItemPort {
    fun getItem(reference: Reference, colorCode: ColorCode): Item?
}