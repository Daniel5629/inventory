package com.dn.inventory.entity

import com.dn.inventory.entity.base.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Table(name = "lot")
@Entity
class LotEntity(

    @Comment("제조일자")
    @Column(name = "manufacturing_date")
    val manufacturingDate: String,

    @Comment("소비기한")
    @Column(name = "expiry_date")
    val expiryDate: String,

    @Comment("센터판매마감일")
    @Column(name = "center_sales_closing_date")
    val centerSalesClosingDate: String,

    @Comment("추가판매마감일")
    @Column(name = "additional_sales_closing_date")
    val additionalSalesClosingDate: String,

    @Comment("입고일자")
    @Column(name = "receiving_date")
    val receivingDate: String

) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lot_id")
    val id: Long? = null
}
