package org.xavrs.streaming.springboot3.domain.model

import org.xavrs.streaming.springboot3.domain.exception.WrongColorException
import org.xavrs.streaming.springboot3.domain.exception.WrongReferenceException

class Item private constructor(
    val reference: Reference,
    val color: Color,
    val name: Name?
): DomainModel {

    data class Builder(
        val reference: String,
        val colorCode: String
    ) {

        private var name: String? = null

        fun withName(name: String) = apply {
            this.name = name
        }

        fun build(): Item{
            return Item(
                reference = Reference(reference),
                color = Color(
                    colorCode = ColorCode(colorCode)
                ),
                name = name
            )
        }
    }
}
@JvmInline
value class Reference(val value: String) {
    init {
        if(value.length != 8) {
            throw WrongReferenceException("Reference must have exactly 8 digits.")
        }
    }
}

typealias Name = String

data class Color(
    val colorCode: ColorCode
)
@JvmInline
value class ColorCode(val value: String) {
    init {
        //TODO Validación todos dígitos
        if(value.length != 2) {
            throw WrongColorException("Color code length must be exactly 2.")
        }
    }
}