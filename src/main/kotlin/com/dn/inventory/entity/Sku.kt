package com.dn.inventory.entity

import com.dn.inventory.common.enumuration.StorageType
import com.dn.inventory.entity.base.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Table(name = "sku")
@Entity
class Sku(

    @Comment("상품명")
    @Column(name = "sku_name")
    val name: String,

    @Comment("보관유형: 상온(H), 냉장(M), 냉동(L) ")
    @Column(name = "storage_type")
    val storageType: StorageType,

    @Comment("상품 대분류")
    @Column(name = "main_category")
    val mainCategory: String,

    @Comment("상품 중분류")
    @Column(name = "middle_category")
    val middleCategory: String,

    @Comment("상품 소분류")
    @Column(name = "sub_category")
    val subCategory: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sku_id")
    val id: Long? = null,
) : BaseEntity()