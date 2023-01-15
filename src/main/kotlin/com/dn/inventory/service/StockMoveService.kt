package com.dn.inventory.service

import com.dn.inventory.controller.dto.CenterStockMoveDto
import com.dn.inventory.controller.dto.StockMoveDto

interface StockMoveService {

    /**
     * 재고이동
     */
    fun stockMove(stockMoveDto: StockMoveDto)

    /**
     * 센터간 재고이동
     */
    fun centerStockMove(centerStockMoveDto: CenterStockMoveDto)

}