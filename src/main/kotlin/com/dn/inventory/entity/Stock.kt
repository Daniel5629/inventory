package com.dn.inventory.entity

import com.dn.inventory.entity.base.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Table(name = "stock")
@Entity
class Stock(

    @Comment("할당수량")
    @Column(name = "allocQty")
    val allocQty: Int,

    @Comment("가용수량")
    @Column(name = "qty")
    val qty: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lot_id")
    val lot: Lot,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    val location: Location,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sku_id")
    val sku: Sku,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    val id: Long? = null,
) : BaseEntity()