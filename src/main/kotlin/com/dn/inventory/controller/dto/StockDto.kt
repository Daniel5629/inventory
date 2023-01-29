package com.dn.inventory.controller.dto

import io.swagger.v3.oas.annotations.media.Schema


data class StockDto(
    @Schema(description = "재고 아이디", example = "1")
    val stockId: Long,

    @Schema(description = "Source 지번 아이디", example = "1")
    val sourceLocationId: Long,

    @Schema(description = "Target 지번 아이디", example = "1")
    val targetLocationId: Long,

    @Schema(description = "이동수량", example = "1")
    val moveQty: Int
)
