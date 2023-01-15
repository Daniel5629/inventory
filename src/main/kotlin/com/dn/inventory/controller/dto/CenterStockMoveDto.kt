package com.dn.inventory.controller.dto

data class CenterStockMoveDto(
    val stockId: Long,
    val moveQty: Int,
    val sourceLocationId: Long,
    val sourceCenter: String,
    val targetLocationId: Long,
    val targetCenter: String
)

