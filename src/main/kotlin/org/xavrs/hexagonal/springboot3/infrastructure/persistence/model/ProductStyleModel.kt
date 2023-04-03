package org.xavrs.hexagonal.springboot3.infrastructure.persistence.model

import jakarta.persistence.*

@Entity
@Table(name = "CL_BF_PURCHASE_STYLE", schema = "PRD_OWNER")
class ProductStyleModel() {
    @Id
    @Column(name = "BF_PURCHASE_STYLE_ID")
    val id: Long? = null

    @Column(name = "BASE_COD_REFERENCE")
    val baseCodeReference: String? = null

    @Column(name = "STYLE_NAME")
    val styleName: String? = null

    @Column(name = "LINE_ID")
    var lineId: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_TYPE_ID")
    var productType: ProductTypeModel? = null
}
