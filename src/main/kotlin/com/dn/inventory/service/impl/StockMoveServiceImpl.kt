package com.dn.inventory.service.impl

import com.dn.inventory.controller.dto.CenterStockMoveDto
import com.dn.inventory.controller.dto.StockMoveDto
import com.dn.inventory.entity.StockEntity
import com.dn.inventory.repository.LocationRepository
import com.dn.inventory.repository.StockRepository
import com.dn.inventory.service.StockMoveService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException

@Service
class StockMoveServiceImpl(
    val stockRepository: StockRepository,
    val locationRepository: LocationRepository
) : StockMoveService {

    @Transactional
    override fun stockMove(stockMoveDto: StockMoveDto) {
        //source
        val sourceLocation = (locationRepository.findByIdOrNull(stockMoveDto.sourceLocationId)
            ?: throw IllegalArgumentException("존재하지 않는 지번입니다."))

        val sourceStock = (stockRepository.findByIdAndLocation(stockMoveDto.stockId, sourceLocation)
            ?: throw IllegalArgumentException("존재하지 않는 재고입니다."))

        var sourceQty = sourceStock.qty
        val moveQty = stockMoveDto.moveQty

        if (sourceQty < moveQty || sourceQty <= 0) {
            throw IllegalArgumentException("이동재고 수량이 부족합니다.")
        }

        //target
        val targetLocation = (locationRepository.findByIdOrNull(stockMoveDto.targetLocationId)
            ?: throw IllegalArgumentException("존재하지 않는 지번입니다."))

        val moveTargetStockEntity = stockRepository.findByIdAndLocation(stockMoveDto.stockId, targetLocation)

        //source 지번 가용재고수량 차감 및 할당수량에 이동수량 셋팅
        sourceQty -= moveQty
        sourceStock.allocQty = moveQty

        //target 지번에 이동하고자 하는 재고가 있다면 수량증가 없다면 재고생성
        if (moveTargetStockEntity == null) {
            val createdTargetStockEntity =
                StockEntity(qty = moveQty, lot = sourceStock.lot, location = targetLocation, sku = sourceStock.sku)

            stockRepository.save(createdTargetStockEntity)
        } else {
            moveTargetStockEntity.qty += moveQty
        }

        //할당수량 해제
        sourceStock.allocQty = 0
    }

    override fun centerStockMove(centerStockMoveDto: CenterStockMoveDto) {
        TODO("Not yet implemented")
    }
}