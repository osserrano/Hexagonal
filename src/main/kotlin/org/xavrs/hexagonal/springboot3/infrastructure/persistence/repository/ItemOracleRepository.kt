package org.xavrs.hexagonal.springboot3.infrastructure.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.xavrs.hexagonal.springboot3.infrastructure.persistence.model.ProductStyleColorModel

@Repository
interface ItemOracleRepository: JpaRepository<ProductStyleColorModel, Long> {
    @Query(
        """
        SELECT SC.*
        FROM CL_BF_PURCHASE_STYLECOLOR SC
        INNER JOIN CL_BF_PURCHASE_STYLE S ON SC.BF_PURCHASE_STYLE_ID = S.BF_PURCHASE_STYLE_ID
        WHERE S.BASE_COD_REFERENCE = :reference AND SC.COLOR_CODE = :color
        """,
        nativeQuery = true
    )
    fun getProductStyleColorByBaseReferencesColor(reference: String, color: String) : List<ProductStyleColorModel>
}