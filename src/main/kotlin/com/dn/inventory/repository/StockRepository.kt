package com.dn.inventory.repository

import com.dn.inventory.entity.LocationEntity
import com.dn.inventory.entity.StockEntity
import jakarta.persistence.LockModeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock

interface StockRepository : JpaRepository<StockEntity, Long> {

    @Lock(LockModeType.OPTIMISTIC)
    fun findByIdAndLocation(stockId: Long, location: LocationEntity) : StockEntity?
}