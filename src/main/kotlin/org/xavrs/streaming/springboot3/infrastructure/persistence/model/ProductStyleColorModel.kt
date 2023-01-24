package org.xavrs.streaming.springboot3.infrastructure.persistence.model

import jakarta.persistence.*
import org.xavrs.streaming.springboot3.domain.model.Item
import java.sql.Timestamp
import java.time.LocalDate


@Entity
@Table(name = "CL_BF_PURCHASE_STYLECOLOR", schema = "PRD_OWNER")
class ProductStyleColorModel() : DBModel {
    @Id
    @Column(name = "BF_PURCHASE_STYLECOLOR_ID")
    var id: Long? = null

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY) // todo revisar esto
    @JoinColumn(name = "BF_PURCHASE_STYLE_ID")
    var bfPurchaseStyle: ProductStyleModel? = null

    @Column(name = "STYLE_IMAGE_CURRENT")
    var currentImage: String? = null

    @Column(name = "COLOR_CODE")
    var colorCode: String? = null

    @Column(name = "IS_ACTIVE_COLOR")
    var isActiveColor: Boolean? = null

    @Column(name = "PHASE_IN_CL")
    var phaseinCl: LocalDate? = null

    @Column(name = "PHASE_IN")
    var phasein: Timestamp? = null

    @Column(name = "WAREHOUSE_STATUS")
    var warehouseStatus: String? = null

    @Column(name = "STORETYPE_ID")
    var storeTypeId: Long? = null

    override fun toDomainModel(): Item {
        return Item.Builder(
            reference = this.bfPurchaseStyle?.baseCodeReference!!,
            colorCode = this.colorCode!!
        ).run {
            bfPurchaseStyle?.styleName?.let { name ->
                withName(name)
            }
            build()
        }
    }
}
