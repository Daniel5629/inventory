package com.dn.inventory.controller

import com.dn.inventory.controller.dto.CenterStockMoveDto
import com.dn.inventory.controller.dto.StockMoveDto
import com.dn.inventory.service.StockMoveService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "1. 재고이동 API")
class StockMoveController(
    private val stockMoveService: StockMoveService
) {
    @PutMapping("/v1/stock-move/stock-move")
    @Operation(summary = "재고 이동 API", description = "재고 이동")
    fun stockMove(@RequestBody stockMoveDto: StockMoveDto): String {
        stockMoveService.stockMove(stockMoveDto)

        return "OK"
    }

    @PutMapping("/v1/stock-move/center-stock-move")
    @Operation(summary = "센터간 재고 이동 API", description = "센터간 재고 이동")
    fun centerStockMove(@RequestBody centerStockMoveDto: CenterStockMoveDto): String {
        stockMoveService.centerStockMove(centerStockMoveDto)

        return "OK"
    }
}