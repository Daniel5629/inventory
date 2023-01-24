package com.dn.inventory.entity

import com.dn.inventory.entity.base.BaseEntity
import javax.persistence.*
import org.hibernate.annotations.Comment

@Table(name = "stock")
@Entity
class StockEntity(

    @Comment("할당수량")
    @Column(name = "allocQty")
    var allocQty: Int = 0,

    @Comment("가용수량")
    @Column(name = "qty")
    var qty: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lot_id")
    val lot: LotEntity,

    @Version
    var version: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    var location: LocationEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sku_id")
    val sku: SkuEntity

) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    val id: Long? = null

}