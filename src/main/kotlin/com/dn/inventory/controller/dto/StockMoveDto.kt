package com.dn.inventory.controller.dto

data class StockMoveDto(
    val stockId: Long,
    val sourceLocationId: Long,
    val targetLocationId: Long,
    val moveQty: Int
)
