package org.xavrs.hexagonal.springboot3.infrastructure.persistence.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "PRD_PRODUCTTYPE_MASTER", schema = "PRD_OWNER")
class ProductTypeModel() {
    @Id
    @Column(name = "PRODUCTTYPE_ID")
    val id: Long? = null

    @Column(name = "NAME_ES")
    val nameEs: String? = null

    @Column(name = "NAME_EN")
    val nameEn: String? = null
}
