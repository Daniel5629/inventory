package com.dn.inventory.entity

import com.dn.inventory.common.enumuration.StorageType
import com.dn.inventory.controller.dto.SkuDto
import com.dn.inventory.entity.base.BaseEntity
import javax.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.DynamicUpdate
import java.lang.IllegalArgumentException

@Table(name = "sku")
@Entity
@DynamicUpdate
class SkuEntity(

    @Comment("상품명")
    @Column(name = "sku_name")
    var name: String,

    @Comment("보관유형: 상온(H), 냉장(M), 냉동(L), 합포(CB) ")
    @Column(name = "storage_type")
    val storageType: StorageType,

    @Comment("상품 대분류")
    @Column(name = "main_category")
    var mainCategory: String,

    @Comment("상품 중분류")
    @Column(name = "middle_category")
    var middleCategory: String,

    @Comment("상품 소분류")
    @Column(name = "sub_category")
    var subCategory: String

) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sku_id")
    val id: Long? = null

    fun toDto(): SkuDto {
        return SkuDto(
            id = this.id,
            name = this.name,
            storageType = this.storageType,
            mainCategory = this.mainCategory,
            middleCategory = this.middleCategory,
            subCategory = this.subCategory
        )
    }

    constructor(skuDto: SkuDto) : this(
        name = skuDto.name!!,
        storageType = skuDto.storageType!!,
        mainCategory = skuDto.mainCategory!!,
        middleCategory = skuDto.middleCategory!!,
        subCategory = skuDto.subCategory!!
    )
}
