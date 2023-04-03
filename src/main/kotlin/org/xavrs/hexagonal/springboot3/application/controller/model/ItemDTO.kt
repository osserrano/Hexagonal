package org.xavrs.hexagonal.springboot3.application.controller.model

import kotlinx.serialization.Serializable

@Serializable
data class ItemDTO (
    val reference: String,
    val color: String,
    val name: String?
)