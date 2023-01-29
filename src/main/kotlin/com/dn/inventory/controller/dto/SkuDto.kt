package com.dn.inventory.controller.dto

import com.dn.inventory.common.enumuration.StorageType
import io.swagger.v3.oas.annotations.media.Schema


data class SkuDto(

    @Schema(description = "상품 아이디", example = "1")
    val id: Long?,

    @Schema(description = "상품명", example = "1")
    val name: String?,

    @Schema(description = "보관유형", example = "1")
    val storageType: StorageType?,

    @Schema(description = "상품 대분류", example = "1")
    val mainCategory: String?,

    @Schema(description = "상품 중분류", example = "1")
    val middleCategory: String?,

    @Schema(description = "상품 소분류", example = "1")
    val subCategory: String?
)
